package com.internship.controller;

import com.internship.bookstore.api.dto.BookResponseDto;
import com.internship.bookstore.api.exchange.Response;
import com.internship.itconfig.Prerequisites;

import org.junit.jupiter.api.BeforeEach;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;
import java.util.List;

import lombok.val;

import static com.internship.TestConstants.AUTH_USER_EMAIL;
import static com.internship.TestConstants.AUTH_USER_PASSWORD;
import static com.internship.TestConstants.createURLWithPort;
import static com.internship.bookstore.utils.BookTestUtils.BOOK_RESPONSE_DTO_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ActiveProfiles("it")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@Sql(scripts = "/db/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD) just for example
public class BookRestControllerTestIt {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private Prerequisites prerequisites;


    @BeforeEach
    void setUp() {
        prerequisites.clear();

        val author = prerequisites.createAuthor();
        prerequisites.createUser();
        prerequisites.createBooks(author);
        prerequisites.createVoucher();
    }

    @Test
    public void shouldReturnAllBooks() throws Exception {
        ResponseEntity<Response<List<BookResponseDto>>> response = testRestTemplate
            .withBasicAuth(AUTH_USER_EMAIL, AUTH_USER_PASSWORD)
            .exchange(
                new URI(createURLWithPort("/books", port)),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Response<List<BookResponseDto>>>() {
                }
            );

        assertNotNull(response.getBody());
        assertEquals(
            BOOK_RESPONSE_DTO_ONE.get().getTitle(),
            response.getBody().getData().get(0).getTitle()
        );
    }
}
