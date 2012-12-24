package com.example.config;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        System.out.println("Servlet 3.0 started...");

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.example.config");

        servletContext.addListener(new ContextLoaderListener(context));

        DispatcherServlet dispatcher = new DispatcherServlet();
        // no explicit configuration reference here: everything is configured in the root container for simplicity
        dispatcher.setContextConfigLocation("");

        ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet", dispatcher);
        appServlet.setLoadOnStartup(1);
        appServlet.setAsyncSupported(true);

        Set<String> mappingConflicts = appServlet.addMapping("/");
        if (!mappingConflicts.isEmpty()) {
            throw new IllegalStateException("'appServlet' cannot be mapped to '/' under Tomcat versions <= 7.0.14");
        }
    }
}