package com.internship.it.service;

import com.internship.bookstore.api.dto.OrderResponseDto;
import com.internship.bookstore.service.OrderService;
import com.internship.it.config.OrderServiceConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.internship.it.utils.OrderRequestUtils.ORDER_REQUEST_DTO_ONE;
import static com.internship.it.utils.OrderRequestUtils.ORDER_RESPONSE_DTO_ONE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = OrderServiceConfig.class)
@TestPropertySource("classpath:exceptions-test.properties")
@Sql(scripts = "/db/test-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class OrderServiceIt {

    @Autowired
    private OrderService orderService;

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
