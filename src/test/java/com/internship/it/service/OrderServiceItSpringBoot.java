package com.internship.it.service;

import com.internship.bookstore.api.dto.OrderResponseDto;
import com.internship.bookstore.repository.AuthorRepository;
import com.internship.bookstore.repository.BookRepository;
import com.internship.bookstore.repository.OrderRepository;
import com.internship.bookstore.repository.UserRepository;
import com.internship.bookstore.repository.VoucherRepository;
import com.internship.bookstore.service.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.internship.it.utils.OrderRequestUtils.ORDER_REQUEST_DTO_ONE;
import static com.internship.it.utils.OrderRequestUtils.ORDER_RESPONSE_DTO_ONE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:exceptions-test.properties")
@ActiveProfiles("test")
@Sql(scripts = "/db/test-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@SpringBootTest
public class OrderServiceItSpringBoot {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @AfterEach
    void tearDown() {
        orderRepository.deleteAll();
        voucherRepository.deleteAll();
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    @WithMockUser(username = "test@domain.com")
    public void shouldSaveOrderRequest() {
        OrderResponseDto expectedResponseDto =
                ORDER_RESPONSE_DTO_ONE.get();

        OrderResponseDto actualOrderResponseDto =
                orderService.save(ORDER_REQUEST_DTO_ONE.get());

        assertAll(
                () -> assertEquals(expectedResponseDto.getPrice(), actualOrderResponseDto.getPrice()),
                () -> assertEquals(expectedResponseDto.getTitle(), actualOrderResponseDto.getTitle()));
    }
}

