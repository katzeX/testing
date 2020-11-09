package com.internship.bookstore.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DiscountRequestDto {
    @NotNull(message =  "Must have value")
    private Long bookId;
    @NotNull(message =  "Must have value")
    private Double discount;
    @NotNull(message =  "Must have value")
    private LocalDate startDate;
    @NotNull(message =  "Must have value")
    private LocalDate endDate;
}
