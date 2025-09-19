package com.sze.studentmanagement.model.dto.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiResponse <T> {
    private String message;
    private T payload;
    private HttpStatus status;
    private LocalDateTime timestamp;
}
