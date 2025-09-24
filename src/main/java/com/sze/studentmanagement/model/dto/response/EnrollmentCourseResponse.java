package com.sze.studentmanagement.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentCourseResponse {
    private StudentResponse students;
    private List<CourseResponse> courses;


}
