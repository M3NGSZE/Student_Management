package com.sze.studentmanagement.service;

import com.sze.studentmanagement.model.dto.request.CourseRequest;
import com.sze.studentmanagement.model.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {

    List<CourseResponse> getAllCourses();

    CourseResponse createCourses(CourseRequest courseRequest);

    CourseResponse updateCourses(Long courseId,CourseRequest courseRequest);

    CourseResponse getCourseById(Long courseId);

    CourseResponse deleteCourses(Long courseId);
}
