package com.ijse.coursework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition(
	info = @io.swagger.v3.oas.annotations.info.Info(
		title = "POS System API",
		version = "v3",
		description = "This is a simple POS System API for the IJSE course work"
	)
)
public class CourseworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseworkApplication.class, args);
	}

}
