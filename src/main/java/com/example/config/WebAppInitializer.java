package com.example.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/*
    <servlet>
         <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
 */
public class WebAppInitializer implements WebApplicationInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAppInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        LOGGER.info("onStartup called");

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.example.config");

        servletContext.addListener(new ContextLoaderListener(context));

        DispatcherServlet dispatcher = new DispatcherServlet();
        // no explicit configuration reference here: everything is configured in the root container for simplicity
        dispatcher.setContextConfigLocation("");

        ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet", dispatcher);
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");

    }
}