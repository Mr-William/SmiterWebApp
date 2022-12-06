package com.org.njproject.smiter.app.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class SmiterAppInitializer implements WebApplicationInitializer {


	@Override
	public void onStartup(ServletContext servletContext) throws javax.servlet.ServletException {
		
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(MvcConfiguration.class);
		webContext.setServletContext(servletContext);
		
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",
				new DispatcherServlet(webContext));
		
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
}