package com.sze.studentmanagement.model.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class StudentCourseRequest {
    private Long studentId;
    private List<CourseRequest> courses;
}
