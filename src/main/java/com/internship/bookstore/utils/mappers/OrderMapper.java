package com.internship.bookstore.utils.mappers;

import com.internship.bookstore.api.dto.OrderResponseDto;
import com.internship.bookstore.model.BookOrder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

    public static final Function<BookOrder, OrderResponseDto> mapBookOrderToOrderResponseDto =
            bookOrder -> OrderResponseDto.builder()
                    .price(bookOrder.getPrice())
                    .title(bookOrder.getBook().getTitle())
                    .build();


}
