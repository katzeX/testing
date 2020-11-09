package com.internship.bookstore.controller;

import com.internship.bookstore.api.controller.BookRestController;
import com.internship.bookstore.service.BookService;
import com.internship.bookstore.service.UserService;
import com.internship.it.controller.BaseController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static com.internship.bookstore.utils.BookTestUtils.BOOK_RESPONSE_DTO_ONE;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookRestController.class)
public class BookRestControllerTest extends BaseController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser
    public void shouldReturnAllBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(Collections.singletonList(BOOK_RESPONSE_DTO_ONE.get()));

        mockMvc.perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(createExpectedBody(Collections.singletonList(BOOK_RESPONSE_DTO_ONE))));

        verify(bookService).getAllBooks();
    }
}
