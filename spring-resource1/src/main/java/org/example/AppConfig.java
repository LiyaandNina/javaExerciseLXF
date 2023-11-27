package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@ComponentScan
@Configuration
public class AppConfig {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppService.class);
        AppService service = context.getBean(AppService.class);
        service.printLogo();
        ((ConfigurableApplicationContext) context).close();
    }

}
