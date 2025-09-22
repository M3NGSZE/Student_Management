package com.sze.studentmanagement.model.dto.response;

import lombok.Data;

@Data
public class CourseResponse {
    private Long courseId;
    private String courseName;
    private String description;
}
