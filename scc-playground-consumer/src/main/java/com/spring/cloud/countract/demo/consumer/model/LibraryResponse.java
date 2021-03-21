/*
 * Copyright (c) by censhare AG
 */

package com.spring.cloud.countract.demo.consumer.model;

public class LibraryResponse {

	private String article;

	public LibraryResponse(String article) {
		this.article = article;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
}
