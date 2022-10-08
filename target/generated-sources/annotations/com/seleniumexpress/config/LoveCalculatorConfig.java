package com.seleniumexpress.config;

import java.util.Properties;
import java.util.logging.Logger;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.seleniumexpress.formatters.PhoneFormatter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.seleniumexpress")
@PropertySource("classpath:email.properties")
public class LoveCalculatorConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	Logger logger = Logger.getLogger(LoveCalculatorConfig.class.getName());

//    Set up view resolver
	@Bean
	InternalResourceViewResolver viewResolver() {
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
	MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("messages");
		return ms;
	}

	@Bean(name = "validator")
	LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;

	}

	@Override
	public org.springframework.validation.Validator getValidator() {
		return validator();
	}

	@Bean
	JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();

		logger.info("----fetching host value----");
		System.out.println(env.getProperty("mail.host"));

		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("mail.username"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
		javaMailSenderImpl.setPort(Integer.parseInt(env.getProperty("mail.port")));

//		Properties properties = new Properties();
//		properties.put("mail.smtp.starttls.enable", true);
//		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//		
//				properties.put("mail.smtp.auth", true);
		javaMailSenderImpl.setJavaMailProperties(getMailProperties());

		return javaMailSenderImpl;
	}

	Properties getMailProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

		return properties;
	}

}
