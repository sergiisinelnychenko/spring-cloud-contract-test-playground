package com.spring.cloud.countract.demo.contract.model;

public class BookResponse {

	private String bookContents;

	public BookResponse() {
	}

	public BookResponse(String bookContents) {
		this.bookContents = bookContents;
	}

	public String getBookContents() {
		return bookContents;
	}

	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}
}
