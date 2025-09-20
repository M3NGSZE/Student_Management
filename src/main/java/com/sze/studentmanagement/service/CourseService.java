package com.sze.studentmanagement.service;

import com.sze.studentmanagement.model.dto.request.CourseRequest;
import com.sze.studentmanagement.model.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course createCourses(Course courseRequest);
}
