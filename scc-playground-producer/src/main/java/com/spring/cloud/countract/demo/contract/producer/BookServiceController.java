package com.spring.cloud.countract.demo.contract.producer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.countract.demo.contract.model.BookErrorResponse;
import com.spring.cloud.countract.demo.contract.model.BookResponse;

@RestController
public class BookServiceController {

	@GetMapping("/book/{bookId}")
	public BookResponse getArticle(@PathVariable("bookId") Integer bookId) {
		if (bookId < 0) {
			throw new IllegalArgumentException("Incorrect book id");
		}
		return new BookResponse("Book with the ID " + bookId);
	}

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<Object> exception(IllegalArgumentException e) {
		return new ResponseEntity<>(new BookErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
