package com.spring.cloud.countract.demo.contract.model;

public class BookErrorResponse {

	private String message;

	public BookErrorResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
