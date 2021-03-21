package com.spring.cloud.countract.demo.contract.producer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public abstract class ContractVerifierBase {

	@InjectMocks
	private BookServiceController controller;

	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(controller);
	}
}
