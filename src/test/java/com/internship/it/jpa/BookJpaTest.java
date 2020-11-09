package com.internship.it.jpa;

import com.internship.bookstore.model.Book;
import com.internship.bookstore.repository.AuthorRepository;
import com.internship.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.internship.TestConstants.ID_ONE;
import static com.internship.bookstore.utils.AuthorTestUtils.AUTHOR_TWO;
import static com.internship.bookstore.utils.BookTestUtils.BOOK_TWO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookJpaTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void shouldFindBookById() {
        testEntityManager.persistAndFlush(AUTHOR_TWO);

        Book savedBook = testEntityManager.persistAndFlush(BOOK_TWO);

        Optional<Book> book = bookRepository.findBookById(ID_ONE);

        assertTrue(book.isPresent());
        assertEquals(book.get().getId(), savedBook.getId());
    }
}
