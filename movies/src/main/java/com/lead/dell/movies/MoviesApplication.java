package com.lead.dell.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MoviesApplication {

	//inicia o projeto
	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
}
