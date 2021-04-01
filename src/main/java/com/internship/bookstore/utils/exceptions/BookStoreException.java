package com.internship.bookstore.utils.exceptions;

import org.slf4j.helpers.MessageFormatter;

import lombok.Getter;

public class BookStoreException extends RuntimeException{

    @Getter
    private final ExceptionType errorType;

    public BookStoreException(ExceptionType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    private BookStoreException(ExceptionType type, Object... messageArgs) {
        super(MessageFormatter.arrayFormat(type.getMessage(), messageArgs).getMessage());
        this.errorType = type;
    }

    private BookStoreException(ExceptionType type, Exception ex) {
        super(type.getMessage(), ex);
        this.errorType = type;
    }

    public static BookStoreException of(ExceptionType type, Exception cause) {
        return new BookStoreException(type, cause);
    }

    public static BookStoreException of(ExceptionType type) {
        return new BookStoreException(type);
    }

    public static BookStoreException of(ExceptionType type, Object... messageArgs) {
        return new BookStoreException(type, messageArgs);
    }
}
