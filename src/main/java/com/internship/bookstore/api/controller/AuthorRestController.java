package com.internship.bookstore.api.controller;

import com.internship.bookstore.api.dto.AuthorResponseDto;
import com.internship.bookstore.api.exchange.Response;
import com.internship.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorRestController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<Response<List<AuthorResponseDto>>> getAllAuthors() {
        return ResponseEntity.ok(Response.build(authorService.getAllAuthors()));
    }
}
