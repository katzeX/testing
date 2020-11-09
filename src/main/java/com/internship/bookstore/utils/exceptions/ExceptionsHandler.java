package com.internship.bookstore.utils.exceptions;


import com.internship.bookstore.api.exchange.Error;
import com.internship.bookstore.api.exchange.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Slf4j
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionResponse(BAD_REQUEST, ex);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> handleUnknownExceptions(Exception ex) {
        return handleExceptionResponse(INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler({
            RecordNotFoundException.class,
            ValidationException.class,
            MethodArgumentTypeMismatchException.class
    })
    protected ResponseEntity<?> handleBadRequests(Exception ex) {
        return handleExceptionResponse(BAD_REQUEST, ex);
    }


    private ResponseEntity<Object> handleExceptionResponse(HttpStatus status, Object customErrorStatus, Throwable exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.status(status).body(Response.build(Error.build(customErrorStatus, exception.getMessage(), LocalDateTime.now())));
    }

    private ResponseEntity<Object> handleExceptionResponse(HttpStatus status, Throwable exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.status(status).body(Response.build(Error.build(status, exception.getMessage(), LocalDateTime.now())));
    }
}
