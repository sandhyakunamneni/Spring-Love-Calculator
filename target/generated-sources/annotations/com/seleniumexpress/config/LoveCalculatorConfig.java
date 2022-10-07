package com.seleniumexpress.config;

import javax.validation.Validator;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
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
    
    
    @Bean
    MessageSource messageSource()
    {
    	ResourceBundleMessageSource ms= new ResourceBundleMessageSource();
    	ms.setBasename("messages");
    	return ms;
    }
    
    @Bean(name="validator")
    LocalValidatorFactoryBean validator()
    {
    	LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
    	localValidatorFactoryBean.setValidationMessageSource(messageSource());
    	return localValidatorFactoryBean;
    	
    }
    @Override
    	public org.springframework.validation.Validator getValidator() {
    		return validator();
    	}
    
}
