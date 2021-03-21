/*
 * Copyright (c) by censhare AG
 */

package com.spring.cloud.countract.demo.consumer.model;

public class LibraryErrorResponse {

	private String message;

	public LibraryErrorResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
