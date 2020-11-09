package com.internship.bookstore.api.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Error<V> {

    private V customStatus;

    private String message;

    private LocalDateTime timestamp;

    public static <V> Error<V> build(V status, String message, LocalDateTime timestamp) {
        return new Error<>(status, message, timestamp);
    }
}