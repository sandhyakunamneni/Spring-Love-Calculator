package com.seleniumexpress.config;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.context.support.XmlWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
////public class LoveCalculatorApplicationInitializer  implements WebApplicationInitializer
//{
//
//	@Override
//	public void onStartup(ServletContext servletContext)  {
//
//
//		AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
//		annotationConfigWebApplicationContext.register(LoveCalculatorConfig.class);
//
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);
//
//		ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("myDispatcherServlet",
//				dispatcherServlet);
//
//		myCustomDispatcherServlet.setLoadOnStartup(1);
//		myCustomDispatcherServlet.addMapping("/mywebsite.com/*");
//	}
//
//}
