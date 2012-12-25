package com.example.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc // equivalent in XML to <mvc:annotation-driven />
@ComponentScan(basePackages = "com.example.controllers")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

}
