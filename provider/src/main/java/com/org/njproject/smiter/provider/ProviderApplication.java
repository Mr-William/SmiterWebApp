package com.org.njproject.smiter.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProviderApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
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
	"name":"Group Awesome",
	"groupEmail": "awesome@sauce.com",
	"ownerName": "William"
	"taskListCount":"0",
	"memberCount":"1"
}
 */