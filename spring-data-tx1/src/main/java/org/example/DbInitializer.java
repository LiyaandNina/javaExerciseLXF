package org.example;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.annotation.PostConstruct;

@Component
public class DbInitializer {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PlatformTransactionManager txManager;

    @PostConstruct
    public void init() {
        System.out.println("init table...");
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS users (" + //
                "id BIGINT IDENTITY NOT NULL," + //
                "email VARCHAR(100) NOT NULL," + //
                "password VARCHAR(100) NOT NULL," + //
                "name VARCHAR(100) NOT NULL," + //
                "PRIMARY KEY (id)," + //
                "UNIQUE (email))");
    }

    @PreDestroy
    public void clean() {
        jdbcTemplate.update("DROP TABLE IF EXISTS users");
    }
}