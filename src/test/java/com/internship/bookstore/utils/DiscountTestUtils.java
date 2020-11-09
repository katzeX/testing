package com.internship.bookstore.utils;

import com.internship.bookstore.api.dto.DiscountRequestDto;
import com.internship.bookstore.api.dto.DiscountResponseDto;
import com.internship.bookstore.model.Discount;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.internship.TestConstants.DISCOUNT_ONE_END_DATE;
import static com.internship.TestConstants.DISCOUNT_ONE_START_DATE;
import static com.internship.TestConstants.DISCOUNT_PERCENTAGE_ONE;
import static com.internship.TestConstants.DISCOUNT_PRICE_ONE;
import static com.internship.TestConstants.ID_ONE;
import static com.internship.bookstore.utils.BookTestUtils.BOOK_ONE;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiscountTestUtils {

    public static final DiscountRequestDto DISCOUNT_REQUEST_DTO = DiscountRequestDto
            .builder()
            .bookId(ID_ONE)
            .discount(DISCOUNT_PERCENTAGE_ONE)
            .startDate(DISCOUNT_ONE_START_DATE)
            .endDate(DISCOUNT_ONE_END_DATE)
            .build();

    public static final DiscountResponseDto DISCOUNT_RESPONSE_DTO = DiscountResponseDto
            .builder()
            .id(ID_ONE)
            .discountPrice(DISCOUNT_PRICE_ONE)
            .bookId(ID_ONE)
            .build();

    public static final Discount DISCOUNT_ONE = Discount.builder()
            .endDate(DISCOUNT_ONE_END_DATE)
            .startDate(DISCOUNT_ONE_START_DATE)
            .discountPrice(DISCOUNT_PRICE_ONE)
            .book(BOOK_ONE)
            .id(ID_ONE)
            .build();
}
