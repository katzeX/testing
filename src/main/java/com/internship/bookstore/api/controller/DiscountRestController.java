package com.internship.bookstore.api.controller;

import com.internship.bookstore.api.dto.DiscountRequestDto;
import com.internship.bookstore.api.dto.DiscountResponseDto;
import com.internship.bookstore.api.exchange.Response;
import com.internship.bookstore.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Objects;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/discount")
@RequiredArgsConstructor
public class DiscountRestController {

    DiscountService discountService;

    @PostMapping
    public ResponseEntity<Response<DiscountResponseDto>> createDiscount(
            @RequestBody @Valid DiscountRequestDto discountRequestDto,
            Errors validationErrors) {

        if (validationErrors.hasErrors()) {
            throw new ValidationException(Objects.requireNonNull(validationErrors.getFieldError()).getDefaultMessage());
        }
        return ok(Response.build(discountService.save(discountRequestDto)));
    }
}
