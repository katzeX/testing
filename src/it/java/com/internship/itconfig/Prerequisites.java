package com.internship.itconfig;

import com.internship.bookstore.model.Author;
import com.internship.bookstore.model.Book;
import com.internship.bookstore.model.User;
import com.internship.bookstore.model.Voucher;
import com.internship.bookstore.repository.AuthorRepository;
import com.internship.bookstore.repository.BookRepository;
import com.internship.bookstore.repository.OrderRepository;
import com.internship.bookstore.repository.UserRepository;
import com.internship.bookstore.repository.VoucherRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import lombok.RequiredArgsConstructor;

import static com.internship.TestConstants.AUTHOR_FIRST_NAME;
import static com.internship.TestConstants.AUTHOR_ID;
import static com.internship.TestConstants.AUTHOR_LAST_NAME;
import static com.internship.TestConstants.AUTH_USER_EMAIL;
import static com.internship.TestConstants.AUTH_USER_PASSWORD1;
import static com.internship.TestConstants.AVAILABLE_BOOKS;
import static com.internship.TestConstants.BOOK_TITLE_ONE;
import static com.internship.TestConstants.ID_ONE;
import static com.internship.TestConstants.LANGUAGE;
import static com.internship.TestConstants.PRICE_ONE;
import static com.internship.TestConstants.VOUCHER_TITLE_ONE;

@Service
@RequiredArgsConstructor
public class Prerequisites {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;
    private final VoucherRepository voucherRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public void clear() {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        userRepository.deleteAll();
        voucherRepository.deleteAll();
        orderRepository.deleteAll();
    }

    @Transactional
    public void createUser() {
        userRepository.save(new User(ID_ONE, AUTH_USER_EMAIL, AUTH_USER_PASSWORD1, null));
    }

    @Transactional
    public Author createAuthor() {
        return authorRepository.save(getAuthor());
    }

    @Transactional
    public Book createBooks(Author author) {
        return bookRepository.save(new Book(ID_ONE, BOOK_TITLE_ONE, author, AVAILABLE_BOOKS, LANGUAGE, PRICE_ONE));
    }

    @Transactional
    public void createVoucher() {
        voucherRepository.save(new Voucher(
            ID_ONE,
            VOUCHER_TITLE_ONE,
            LocalDate.parse("2020-10-05"),
            LocalDate.parse("2050-11-05"),
            PRICE_ONE
        ));
    }

    private Author getAuthor() {
        return Author.builder()
            .id(AUTHOR_ID)
            .firstName(AUTHOR_FIRST_NAME)
            .lastName(AUTHOR_LAST_NAME)
            .books(null)
            .build();
    }
}
