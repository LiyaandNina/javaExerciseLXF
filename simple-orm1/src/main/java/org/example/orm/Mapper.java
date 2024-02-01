package org.example.orm;

import jakarta.persistence.Table;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

final class Mapper<T> {

    final Class<T> entityClass;

    final String tableName;

    // id
    final AccessibleProperty id;

    final List<AccessibleProperty> allProperties;

    // lower-case property name -> all properties
    final Map<String, AccessibleProperty> allPropertiesMap;

    final List<AccessibleProperty> insertableProperties;

    final List<AccessibleProperty> updatableProperties;

    final Map<String, AccessibleProperty> updatablePropertiesMap;

    final RowMapper<T> rowMapper;

    final String selectSQL;
    final String insertSQL;
    final String updateSQL;
    final String deleteSQL;

    public Mapper(Class<T> clazz) throws Exception {
        List<AccessibleProperty> all = getProperties(clazz);
        AccessibleProperty[] ids = all.stream().filter(AccessibleProperty::isId).toArray(AccessibleProperty[]::new);
        if (ids.length != 1) {
            throw new RuntimeException("Require exact one @Id.");
        }
        this.id = ids[0];
        this.entityClass = clazz;
        this.tableName = getTableName(clazz);
        this.allProperties = all;
        this.allPropertiesMap = buildPropertiesMap(all);
        this.insertableProperties = all.stream().filter(AccessibleProperty::isInsertable).collect(Collectors.toList());
        this.updatableProperties = all.stream().filter(AccessibleProperty::isUpdatable).collect(Collectors.toList());
        this.updatablePropertiesMap = buildPropertiesMap(this.updatableProperties);
        this.rowMapper = new BeanPropertyRowMapper<>(this.entityClass);

        this.selectSQL = "SELECT * FROM " + this.tableName + " WHERE " + this.id.columnName + " = ?";
        this.insertSQL = "INSERT INTO " + this.tableName + " ("
                + String.join(", ", this.insertableProperties.stream().map(p -> p.columnName).toArray(String[]::new)) + ") VALUES ("
                + numOfQuestions(this.insertableProperties.size()) + ")";
        this.updateSQL = "UPDATE " + this.tableName + " SET "
                + String.join(", ", this.updatableProperties.stream().map(p -> p.columnName + " = ?").toArray(String[]::new)) + " WHERE " + this.id.columnName
                + " = ?";
        this.deleteSQL = "DELETE FROM " + this.tableName + " WHERE " + this.id.columnName + " = ?";
    }

    Object getIdValue(Object bean) throws ReflectiveOperationException {
        return this.id.getter.invoke(bean);
    }

    private String numOfQuestions(int length) {
        String[] tmp = new String[length];
        return String.join(", ", Arrays.stream(tmp).map(s -> {
            return "?";
        }).toArray(String[]::new));
    }

    private Map<String, AccessibleProperty> buildPropertiesMap(List<AccessibleProperty> props) {
        Map<String, AccessibleProperty> map = new HashMap<>();
        for (AccessibleProperty prop: props) {
            map.put(prop.propertyName.toLowerCase(), prop);
        }
        return map;
    }

    private String getTableName(Class<?> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        if (table != null && !table.name().isEmpty()) {
            return table.name();
        }
        return clazz.getSimpleName();
    }

    private List<AccessibleProperty> getProperties(Class<T> clazz) throws Exception {
        List<AccessibleProperty> accessibleProperties = new ArrayList<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : propertyDescriptors) {
            if (pd.getName().equals("class")) {
                continue;
            }
            Method getter = pd.getReadMethod();
            Method setter = pd.getWriteMethod();
            // 忽略 Transient 注解
            if (getter != null && getter.isAnnotationPresent(Transient.class)) {
                continue;
            }
            if (getter != null && setter != null) {
                accessibleProperties.add(new AccessibleProperty(pd));
            } else {
                throw new RuntimeException("Property " + pd.getName() + "is not read/write.");
            }
        }
        return accessibleProperties;
    }
}
