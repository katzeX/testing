package com.internship.bookstore.utils;

import com.internship.bookstore.api.dto.BookResponseDto;
import com.internship.bookstore.model.Book;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

import static com.internship.TestConstants.AVAILABLE_BOOKS;
import static com.internship.TestConstants.BOOK_TITLE_ONE;
import static com.internship.TestConstants.ID_ONE;
import static com.internship.TestConstants.LANGUAGE;
import static com.internship.TestConstants.PRICE_ONE;
import static com.internship.bookstore.utils.AuthorTestUtils.AUTHOR_ONE;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookTestUtils {

    public static final Book BOOK_ONE = Book.builder()
            .bookLanguage(LANGUAGE)
            .author(AUTHOR_ONE)
            .price(PRICE_ONE)
            .availableBooks(AVAILABLE_BOOKS)
            .title(BOOK_TITLE_ONE)
            .id(ID_ONE)
            .build();

    public static final Supplier<BookResponseDto> BOOK_RESPONSE_DTO_ONE =
            () -> BookResponseDto.builder()
                    .author(AUTHOR_ONE.getFirstName().concat(AUTHOR_ONE.getLastName()))
                    .title(BOOK_TITLE_ONE)
                    .id(ID_ONE)
                    .build();

    public static final Book BOOK_TWO = Book.builder()
            .bookLanguage(LANGUAGE)
            .author(AUTHOR_ONE)
            .price(PRICE_ONE)
            .availableBooks(AVAILABLE_BOOKS)
            .title(BOOK_TITLE_ONE)
            .build();
}
