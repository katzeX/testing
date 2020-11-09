package com.internship.it.controller;

import com.internship.bookstore.api.dto.BookResponseDto;
import com.internship.bookstore.api.exchange.Response;
import com.internship.bookstore.repository.AuthorRepository;
import com.internship.bookstore.repository.BookRepository;
import com.internship.bookstore.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;
import java.util.List;

import static com.internship.TestConstants.AUTH_USER_EMAIL;
import static com.internship.TestConstants.AUTH_USER_PASSWORD;
import static com.internship.TestConstants.createURLWithPort;
import static com.internship.bookstore.utils.BookTestUtils.BOOK_RESPONSE_DTO_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestPropertySource("classpath:exceptions-test.properties")
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/db/test-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class BookRestControllerTestIt {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void shouldReturnAllBooks() throws Exception {
        ResponseEntity<Response<List<BookResponseDto>>> response = testRestTemplate
                .withBasicAuth(AUTH_USER_EMAIL, AUTH_USER_PASSWORD)
                .exchange(new URI(createURLWithPort("/books", port)),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Response<List<BookResponseDto>>>() {
                        });

        assertNotNull(response.getBody());
        assertEquals(BOOK_RESPONSE_DTO_ONE.get().getTitle(),
                response.getBody().getData().get(0).getTitle());
    }
}
