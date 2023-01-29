package com.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BookApplication.class, args);

		SpringApplication application = new SpringApplication(BookApplication.class); 
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
