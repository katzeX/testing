package com.internship.bookstore.utils.exceptions;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ExceptionType {

    INTERNAL_SERVER_ERROR("Internal server error", 500),
    NOT_FOUND_ERROR("Not found", 404),
    OPERATION_WAS_NOT_IMPLEMENTED_YET("Operation was not implemented yet", 501),
    INVALID_AUTHORIZATION("Invalid authorization token", 401),
    BOOK_NOT_FOUND("Book with ID=[{}] wasn't found", 404),
    AUTHOR_NOT_FOUND("Author with ID=[{}] wasn't found", 404),
    USER_NOT_FOUND("User with mail=[{}] wasn't found", 404),
    VOUCHER_NOT_FOUND("Voucher with title=[{}] wasn't found", 404);

    final String message;
    final int statusCode;
}
