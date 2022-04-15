package com.jakesmommy.lesson.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jakesmommy")
public class JsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonApplication.class, args);
	}

}
