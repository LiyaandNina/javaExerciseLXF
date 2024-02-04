package org.example.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class DbTemplate {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    final JdbcTemplate jdbcTemplate;

    private Map<Class<?>, Mapper<?>> classMapping;

    public DbTemplate(JdbcTemplate jdbcTemplate, String basePackage) {
        this.jdbcTemplate = jdbcTemplate;
        List<Class<?>> classes = scanEntities(basePackage);
        Map<Class<?>, Mapper<?>> classMapping = new HashMap<>();
        try {
            for (Class<?> clazz: classes) {
                logger.info("Found class:" + clazz.getName());
                classMapping.put(clazz, new Mapper<>(clazz));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.classMapping = classMapping;
    }

    public <T> T fetch(Class<T> tClass, Object id) {
        Mapper<T> mapper = getMapper(tClass);
        logger.info("Sql:" + mapper.selectSQL);
        List<T> list = (List<T>) this.jdbcTemplate.query(mapper.selectSQL, mapper.rowMapper, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public <T> T get(Class<T> tClass, Object id) {
        T t = fetch(tClass, id);
        if (t == null) {
            throw new EntityNotFoundException(tClass.getName());
        }
        return t;
    }

    public <T> void delete(T bean) {
        try {
            Mapper<?> mapper = getMapper(bean.getClass());
            delete(bean.getClass(), mapper.getIdValue(bean));
        } catch (ReflectiveOperationException e) {
            throw new PersistenceException(e);
        }
    }

    <T> void delete(Class<T> tClass, Object id) {
        Mapper<T> mapper = getMapper(tClass);
        logger.info("Sql:" + mapper.deleteSQL);
        this.jdbcTemplate.update(mapper.deleteSQL, mapper.rowMapper, id);
    }

    <T> Mapper<T> getMapper(Class<T> tClass) {
        Mapper<T> mapper = (Mapper<T>) this.classMapping.get(tClass);
        if (mapper == null) {
            throw new RuntimeException("Target class is not a registered entity: " + tClass.getName());
        }
        return mapper;
    }

    private List<Class<?>> scanEntities(String basePackge) {
        ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
        List<Class<?>> classes = new ArrayList<>();
        Set<BeanDefinition> beans = provider.findCandidateComponents(basePackge);
        for(BeanDefinition bean: beans) {
            try {
                classes.add(Class.forName(bean.getBeanClassName()));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return classes;
    }
}
