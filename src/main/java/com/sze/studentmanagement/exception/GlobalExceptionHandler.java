package com.sze.studentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundExceptionHandler.class)
    public ProblemDetail handleException(NotFoundExceptionHandler e) {
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());

        // if we want to have more detail

//        detail.setType(URI.create("about:blank"));
//        detail.setTitle("Not Found");
//        detail.setDetail(e.getMessage());

        detail.setProperty("timestamp", LocalDateTime.now());

        return detail;
    }
}
