package org.example.orm;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

class AccessibleProperty {
    // Method:
    final Method getter;
    final Method setter;

    //java type
    final Class<?> propertyType;

    //java bean property name
    final String propertyName;

    //table column name
    final String columnName;

    boolean isId() { return this.getter.isAnnotationPresent(Id.class); }

    //判断是否是自增主键
    boolean isIdentifyId() {
        if(!isId()){
            return false;
        }
        //获取GeneratedValue注解信息
        GeneratedValue gv = this.getter.getAnnotation(GeneratedValue.class);
        if (gv == null) {
            return false;
        }
        GenerationType generationType = gv.strategy();
        return generationType == GenerationType.IDENTITY;
    }

    //判断是否可插入
    boolean isInsertable() {
        if (isIdentifyId()) {
            return false;
        }
        Column col = this.getter.getAnnotation(Column.class);
        return col == null || col.insertable();
    }

    boolean isUpdatable() {
        if (isId()) {
            return false;
        }
        Column col = this.getter.getAnnotation(Column.class);
        return col == null || col.updatable();
    }

    //尝试去除public
    //初始化
    AccessibleProperty(PropertyDescriptor pd) {
        this.getter = pd.getReadMethod();
        this.setter = pd.getWriteMethod();
        this.propertyType = pd.getPropertyType();
        this.propertyName = pd.getName();
        this.columnName = getColumnName(pd.getReadMethod(), pd.getName());
    }

    //从getter方法的注解获取列名，默认使用属性名
    private String getColumnName(Method m, String defaultName) {
        Column col = m.getAnnotation(Column.class);
        if (col == null || col.name().isEmpty()) {
            return defaultName;
        }
        return col.name();
    }

}
