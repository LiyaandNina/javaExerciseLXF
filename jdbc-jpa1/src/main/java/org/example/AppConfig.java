package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.example.entity.AbstractEntity;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@ComponentScan
@Configuration
@EnableTransactionManagement
@PropertySource("jdbc.properties")
public class AppConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        if (userService.fetchUserByEmail("bob@example.com") == null) {
            User bob = userService.register("bob@example.com", "bob123", "Bob");
            System.out.println("Registered ok: " + bob);
        }
        if (userService.fetchUserByEmail("alice@example.com") == null) {
            try {
                User alice = userService.register("alice@example.com", "helloalice", "Alice");
                System.out.println("Registered ok: " + alice);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 查询所有用户:
        for (User u : userService.getUsers(1)) {
            System.out.println(u);
        }
        User bob = userService.login("bob@example.com", "bob123");
        System.out.println(bob);
        ((ConfigurableApplicationContext) context).close();
    }

    @Bean
    DataSource createDataSource(
            // JDBC URL:
            @Value("${jdbc.url}") String jdbcUrl,
            // JDBC username:
            @Value("${jdbc.username}") String jdbcUsername,
            // JDBC password:
            @Value("${jdbc.password}") String jdbcPassword) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setPassword(jdbcPassword);
        config.setUsername(jdbcUsername);
        config.addDataSourceProperty("autoCommit", "false");
        config.addDataSourceProperty("connectionTimeout", "5");
        config.addDataSourceProperty("idleTimeout", "60");
        return new HikariDataSource(config);
    }

    //创建工厂Bean用于jpa
    @Bean
    LocalContainerEntityManagerFactoryBean createEntityManagerFactory(@Autowired DataSource dataSource) {
        var emFactory = new LocalContainerEntityManagerFactoryBean();
        emFactory.setDataSource(dataSource);
        emFactory.setPackagesToScan(AbstractEntity.class.getPackageName());
        // 使用Hibernate 作为jpa实现
        emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        var props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto", "update"); // 生产环境不要使用
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        props.setProperty("hibernate.show_sql", "true");
        emFactory.setJpaProperties(props);
        return emFactory;
    }

    @Bean
    PlatformTransactionManager createTxManager(@Autowired EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}