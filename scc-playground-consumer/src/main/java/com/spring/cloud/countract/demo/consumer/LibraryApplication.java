/*
 * Copyright (c) by censhare AG
 */
package com.spring.cloud.countract.demo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
