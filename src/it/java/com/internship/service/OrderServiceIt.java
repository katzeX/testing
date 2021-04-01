package com.internship.service;

import com.internship.bookstore.api.dto.OrderResponseDto;
import com.internship.bookstore.service.OrderService;
import com.internship.itconfig.OrderServiceConfig;
import com.internship.itconfig.Prerequisites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.val;

import static com.internship.utils.OrderRequestUtils.ORDER_REQUEST_DTO_ONE;
import static com.internship.utils.OrderRequestUtils.ORDER_RESPONSE_DTO_ONE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("it")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = OrderServiceConfig.class)
public class OrderServiceIt {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Prerequisites prerequisites;

    @BeforeEach
    void setUp() {
        prerequisites.clear();

        val author = prerequisites.createAuthor();
        prerequisites.createUser();
        prerequisites.createBooks(author);
        prerequisites.createVoucher();
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
