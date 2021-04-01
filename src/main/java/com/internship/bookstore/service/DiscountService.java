package com.internship.bookstore.service;

import com.internship.bookstore.api.dto.DiscountRequestDto;
import com.internship.bookstore.api.dto.DiscountResponseDto;
import com.internship.bookstore.model.Book;
import com.internship.bookstore.model.Discount;
import com.internship.bookstore.repository.BookRepository;
import com.internship.bookstore.repository.DiscountRepository;
import com.internship.bookstore.utils.exceptions.BookStoreException;
import com.internship.bookstore.utils.exceptions.ExceptionType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.internship.bookstore.utils.mappers.DiscountMapper.mapDiscountRequestDtoToDiscount;
import static com.internship.bookstore.utils.mappers.DiscountMapper.mapDiscountToDiscountResponseDto;
import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiscountService {

    private final BookRepository bookRepository;
    private final DiscountRepository discountRepository;


    private double calculateDiscount(double discountPercentage, double price) {
        return price - ((discountPercentage * price) / 100);
    }

    @Transactional
    public DiscountResponseDto save(DiscountRequestDto discountRequestDto) {
        log.info("Saving discount for book with: id [{}]", discountRequestDto.getBookId());

        Book book = bookRepository.findBookById(discountRequestDto.getBookId()).orElseThrow(() -> {
            log.warn("Book with id [{}] was not found in the database", discountRequestDto.getBookId());
            return BookStoreException.of(ExceptionType.BOOK_NOT_FOUND, discountRequestDto.getBookId());
        });

        Discount discount = mapDiscountRequestDtoToDiscount.apply(discountRequestDto);

        discount.setBook(book);
        discount.setDiscountPrice(calculateDiscount(discountRequestDto.getDiscount(), book.getPrice()));

        discount = discountRepository.save(discount);

        return mapDiscountToDiscountResponseDto.apply(discount);
    }
}
