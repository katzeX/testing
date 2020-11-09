package com.internship.bookstore.service;

import com.internship.bookstore.api.dto.BookRequestDto;
import com.internship.bookstore.api.dto.BookResponseDto;
import com.internship.bookstore.model.Author;
import com.internship.bookstore.model.Book;
import com.internship.bookstore.repository.AuthorRepository;
import com.internship.bookstore.repository.BookRepository;
import com.internship.bookstore.utils.exceptions.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.internship.bookstore.utils.mappers.BookMapper.mapBookRequestDtoToBook;
import static com.internship.bookstore.utils.mappers.BookMapper.mapBookToBookResponseDto;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    @Value("${message.book.not-found}")
    private String messageBookNotFound;
    @Value("${message.author.not-found}")
    private String messageAuthorNotFound;

    @Transactional(readOnly = true)
    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(mapBookToBookResponseDto)
                .collect(toList());
    }

    @Transactional
    public BookResponseDto save(BookRequestDto bookRequestDto) {
        log.info("Saving book with: title [{}] and authorId [{}]", bookRequestDto.getTitle(),
                bookRequestDto.getAuthorId());

        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).orElseThrow(
                () -> { log.warn("Author with id [{}] was not found in database",
                            bookRequestDto.getAuthorId());
                    return new RecordNotFoundException(
                            format(messageAuthorNotFound, bookRequestDto.getAuthorId()));
                });

        Book book = mapBookRequestDtoToBook.apply(bookRequestDto);
        book.setAuthor(author);

        book = bookRepository.save(book);

        return mapBookToBookResponseDto.apply(book);
    }
}
