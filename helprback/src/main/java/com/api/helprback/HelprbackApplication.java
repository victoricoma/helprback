package com.api.helprback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelprbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelprbackApplication.class, args);
		System.out.println("API do Web App Helpr rodando!");
	}
}
