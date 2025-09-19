package com.sze.studentmanagement.model.dto.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
public class ApiResponse <T> {
    private String message;
    private T payload;
    private HttpStatus status;
    private LocalDateTime timestamp;
}
