/*
 * Copyright (c) by censhare AG
 */
package com.spring.cloud.countract.demo.consumer;

import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.spring.cloud.countract.demo.consumer.model.LibraryErrorResponse;
import com.spring.cloud.countract.demo.consumer.model.LibraryResponse;
import com.spring.cloud.countract.demo.contract.model.BookResponse;

@RestController
public class LibraryController {

    private final RestTemplate restTemplate;

    public LibraryController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/library/{acticleId}")
    public LibraryResponse getArticle(@PathVariable("acticleId") Integer acticleId) {

        ResponseEntity<BookResponse> fileServiceResponse;
        try {
            fileServiceResponse = this.restTemplate.exchange(
                    URI.create("http://localhost:8090/book/" + acticleId),
                    HttpMethod.GET, null, BookResponse.class);
        } catch(HttpClientErrorException e) {
            throw new IllegalArgumentException("not able to find the article");
        }

        return new LibraryResponse(fileServiceResponse.getBody().getBookContents());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> exception(IllegalArgumentException e) {
        return new ResponseEntity<>(new LibraryErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
