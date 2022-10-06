package com.seleniumexpress.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.seleniumexpress.api.formatters.PhoneFormatter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.seleniumexpress.controllers")
public class LoveCalculatorConfig implements WebMvcConfigurer{

//    Set up view resolver
    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Override
    	public void addFormatters(FormatterRegistry registry) {
    		registry.addFormatter(new PhoneFormatter());
    	}
}
