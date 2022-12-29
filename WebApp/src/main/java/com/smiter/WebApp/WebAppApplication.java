package com.smiter.WebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.smiter.webapp")
public class WebAppApplication extends SpringBootServletInitializer{


	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebAppApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}
}