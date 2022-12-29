package com.smiter.Provider;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class ProviderApplication {

	private String access = "Access-Control-Allow-Origin";
	
	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

	@Bean
	public CorsFilter filter() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Arrays.asList("http://localhost:8081"));
		config.setAllowedHeaders(Arrays.asList("Origin", access,
				"Content-Type","Accept","Authorization","Origin,Accept","X-Requested-With",
				"Access-Control-Request-Method","Access-Control-Request-Headers"));
				config.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept","Authorization",
				access, "Access-Control-Allow-Credentials"));
				config.setAllowedMethods(Arrays.asList("GET","PUT","POST","DELETE","OPTIONS"));
		UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
		src.registerCorsConfiguration("/**", config);
		return new CorsFilter(src);
		
	}

}


/*
{
	"userName":"will",
    "name":"william",
    "email":"w.g@g.com",
    "password":"asdf",
    "company":"home",
    "userType":"owner"
}

{
	"name":"Group A",
	"groupEmail": "a@b.com",
	"ownerName": "William"
	"taskListCount":"0",
	"memberCount":"1"
}
 */