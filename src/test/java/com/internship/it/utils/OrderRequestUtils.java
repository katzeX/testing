package com.internship.it.utils;

import com.internship.bookstore.api.dto.OrderRequestDto;
import com.internship.bookstore.api.dto.OrderResponseDto;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

import static com.internship.TestConstants.BOOK_TITLE_ONE;
import static com.internship.TestConstants.ID_ONE;
import static com.internship.TestConstants.PRICE_TWO;
import static com.internship.TestConstants.VOUCHER_TITLE_ONE;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class OrderRequestUtils {

    public static final Supplier<OrderRequestDto> ORDER_REQUEST_DTO_ONE =
            () -> OrderRequestDto.builder()
                    .bookId(ID_ONE)
                    .voucherTitle(VOUCHER_TITLE_ONE)
                    .build();

    public static final Supplier<OrderResponseDto> ORDER_RESPONSE_DTO_ONE =
            () -> OrderResponseDto.builder()
                    .title(BOOK_TITLE_ONE)
                    .price(PRICE_TWO)
                    .build();
}
