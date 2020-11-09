package com.internship.bookstore.utils;

import com.internship.bookstore.model.Author;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.internship.TestConstants.ID_ONE;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorTestUtils {

    public static final Author AUTHOR_ONE = Author.builder()
            .firstName("Mary")
            .lastName("Shelley")
            .id(ID_ONE)
            .build();

    public static final Author AUTHOR_TWO = Author.builder()
            .firstName("Mary")
            .lastName("Shelley")
            .build();
}
