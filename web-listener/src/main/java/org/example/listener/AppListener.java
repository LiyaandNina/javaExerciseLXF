package org.example.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized (ServletContextEvent se) {
        System.out.println("Webapp Initialized. Servlet Context = " + se.getServletContext());
    }

    @Override
    public void contextDestroyed (ServletContextEvent se) {
        System.out.println("Webapp destroyed...");
    }
}
