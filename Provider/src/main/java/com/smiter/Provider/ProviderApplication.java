package com.smiter.Provider;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableJpaRepositories("com.smiter.*")
@EntityScan("com.smiter.*")
@ComponentScan("com.smiter.*")
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
 ----FOR POSTMAN ENTRY-----
 
 ----BOOK POST-----
 {
   "title":"Don Quixote",
   "author":"Miguel de Cervantes",
   "genre": "Fiction",
   "datecompleted": "2022-10-14"
 }
   
  
  ----GAME POST----
  {
	"title":"Elden Ring",
	"genre":"Action RPG",
	"datecompleted":"2023-01-04"
  }

  ----MUSIC POST----
  {
	"songTitle":"Brighter Side of Grey",
	"albumTitle":"F8",
	"artist":"Five Finger Death Punch",
	"genre":"Metal"
  }
  
  ----Movies Post----
  {
	"title":"Liar Liar",
	"genre":"Comedy", 
	"director":"Tom Shadyac",
	"producer":"Brian Grazer"
  }
 */