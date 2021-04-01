package com.internship.service;

import com.internship.bookstore.api.dto.OrderResponseDto;
import com.internship.bookstore.model.Book;
import com.internship.bookstore.service.OrderService;
import com.internship.itconfig.Prerequisites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.val;

import static com.internship.utils.OrderRequestUtils.ORDER_REQUEST_DTO_ONE;
import static com.internship.utils.OrderRequestUtils.ORDER_RESPONSE_DTO_ONE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("it")
//@Sql(scripts = "/db/test-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@SpringBootTest
public class OrderServiceItSpringBoot {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Prerequisites prerequisites;

    private Book savedBook;

    @BeforeEach
    void setUp() {
        prerequisites.clear();

        val author = prerequisites.createAuthor();
        prerequisites.createUser();
        savedBook = prerequisites.createBooks(author);
        prerequisites.createVoucher();
    }

    @Test
    @WithMockUser(username = "test@domain.com")
    public void shouldSaveOrderRequest() {
        OrderResponseDto expectedResponseDto =
                ORDER_RESPONSE_DTO_ONE.get();

        OrderResponseDto actualOrderResponseDto =
                orderService.save(ORDER_REQUEST_DTO_ONE.get().toBuilder().bookId(savedBook.getId()).build());

        assertAll(
                () -> assertEquals(expectedResponseDto.getPrice(), actualOrderResponseDto.getPrice()),
                () -> assertEquals(expectedResponseDto.getTitle(), actualOrderResponseDto.getTitle()));
    }
}

