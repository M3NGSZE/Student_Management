package com.sze.studentmanagement.service;

import com.sze.studentmanagement.model.dto.response.EnrollmentCourseResponse;
import com.sze.studentmanagement.model.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {
    EnrollmentCourseResponse getEnrollmentByStudentId(Long studentId);

    EnrollmentCourseResponse addEnrollmentByStudentId(Long studentId, List<Long> courseIds);
}
