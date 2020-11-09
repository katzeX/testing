package com.internship.bookstore.api.controller;

import com.internship.bookstore.api.dto.OrderRequestDto;
import com.internship.bookstore.api.dto.OrderResponseDto;
import com.internship.bookstore.api.exchange.Response;
import com.internship.bookstore.service.OrderService;
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
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Response<OrderResponseDto>> createOrder(
            @RequestBody @Valid OrderRequestDto orderRequestDto,
            Errors validationErrors) {

        if (validationErrors.hasErrors()) {
            throw new ValidationException(Objects.requireNonNull(validationErrors.getFieldError()).getDefaultMessage());
        }
        return ok(Response.build(orderService.save(orderRequestDto)));
    }
}
