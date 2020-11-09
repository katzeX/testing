package com.internship.bookstore.utils.mappers;

import com.internship.bookstore.api.dto.BookRequestDto;
import com.internship.bookstore.api.dto.BookResponseDto;
import com.internship.bookstore.model.Book;
import lombok.NoArgsConstructor;

import java.util.function.Function;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class BookMapper {

    public static final Function<Book, BookResponseDto> mapBookToBookResponseDto = book -> BookResponseDto.builder()
            .id(book.getId())
            .title(book.getTitle())
            .author(book.getAuthor().getFirstName().
                    concat(book.getAuthor().getLastName())).build();

    public static final Function<BookRequestDto, Book> mapBookRequestDtoToBook = bookRequestDto ->
            Book.builder()
                    .title(bookRequestDto.getTitle())
                    .bookLanguage(bookRequestDto.getBookLanguage())
                    .availableBooks(bookRequestDto.getAvailableBooks())
                    .price(bookRequestDto.getPrice())
                    .build();
}
