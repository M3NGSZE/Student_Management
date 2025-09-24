package com.sze.studentmanagement.service;

import com.sze.studentmanagement.model.dto.response.EnrollmentCourseResponse;
import com.sze.studentmanagement.model.entity.Enrollment;

public interface EnrollmentService {
    EnrollmentCourseResponse getEnrollmentByStudentId(Long studentId);
}
