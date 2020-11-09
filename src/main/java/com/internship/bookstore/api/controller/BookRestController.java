package com.internship.bookstore.api.controller;

import com.internship.bookstore.api.dto.BookRequestDto;
import com.internship.bookstore.api.dto.BookResponseDto;
import com.internship.bookstore.api.exchange.Response;
import com.internship.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<Response<List<BookResponseDto>>> getAllBooks() {
        return ResponseEntity.ok(Response.build(bookService.getAllBooks()));
    }

    @PostMapping
    public ResponseEntity<Response<BookResponseDto>> createBook(
            @RequestBody @Valid BookRequestDto bookRequestDto, Errors validationErrors) {

        if (validationErrors.hasErrors()) {
            throw new ValidationException(Objects.requireNonNull(validationErrors.getFieldError()).getDefaultMessage());
        }

        return ResponseEntity.ok(Response.build(bookService.save(bookRequestDto)));
    }
}
