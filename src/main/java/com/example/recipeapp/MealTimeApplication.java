package com.example.recipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(
	    info = @Info(
	        title = "It's your Meal Time ",
	        version = "1.0",
	        description = "API for food items and recepies"
	    )
	)
@SpringBootApplication
public class MealTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealTimeApplication.class, args);
	}

}
