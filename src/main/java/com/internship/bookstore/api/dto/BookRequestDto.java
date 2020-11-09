package com.internship.bookstore.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookRequestDto {
    @NotBlank(message = "Must not be blank")
    private String title;
    @NotNull(message =  "Must have value")
    private Long authorId;
    private Double price;
    private String bookLanguage;
    private Integer availableBooks;
}
