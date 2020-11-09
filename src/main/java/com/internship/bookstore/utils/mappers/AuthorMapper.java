package com.internship.bookstore.utils.mappers;

import com.internship.bookstore.api.dto.AuthorResponseDto;
import com.internship.bookstore.model.Author;
import lombok.NoArgsConstructor;

import java.util.function.Function;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class AuthorMapper {

    public static final Function<Author, AuthorResponseDto> mapAuthorToAuthorResponseDto = author ->
            AuthorResponseDto.builder()
                    .id(author.getId())
                    .name(author.getFirstName().
                            concat(author.getLastName())).build();

}
