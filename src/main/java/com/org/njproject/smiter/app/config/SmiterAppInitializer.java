package com.org.njproject.smiter.app.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class SmiterAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] {
            "/"
        };
    }

	@Override
	protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                HibernateConfig.class
            };
        }


	@Override 
	protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                MvcConfiguration.class
            };
        }
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("h2-console", new WebServlet());
		servlet.setLoadOnStartup(2);
		servlet.addMapping("/db/*");
	}
}