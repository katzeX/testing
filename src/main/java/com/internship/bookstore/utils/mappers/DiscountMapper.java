package com.internship.bookstore.utils.mappers;

import com.internship.bookstore.api.dto.DiscountRequestDto;
import com.internship.bookstore.api.dto.DiscountResponseDto;
import com.internship.bookstore.model.Discount;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiscountMapper {

    public static final Function<DiscountRequestDto, Discount> mapDiscountRequestDtoToDiscount =
            discountRequestDto -> Discount.builder()
                    .startDate(discountRequestDto.getEndDate())
                    .endDate(discountRequestDto.getEndDate()).build();

    public static final Function<Discount, DiscountResponseDto> mapDiscountToDiscountResponseDto =
            discount -> DiscountResponseDto.builder()
                    .bookId(discount.getBook().getId())
                    .discountPrice(discount.getDiscountPrice())
                    .build();
}
