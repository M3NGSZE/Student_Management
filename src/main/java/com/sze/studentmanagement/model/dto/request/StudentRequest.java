package com.sze.studentmanagement.model.dto.request;

import lombok.Data;

@Data
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
}
