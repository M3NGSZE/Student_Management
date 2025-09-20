package com.sze.studentmanagement.service.impl;

import com.sze.studentmanagement.mapper.CourseMapper;
import com.sze.studentmanagement.model.dto.request.CourseRequest;
import com.sze.studentmanagement.model.entity.Course;
import com.sze.studentmanagement.repository.CourseRepository;
import com.sze.studentmanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourses(CourseRequest courseRequest) {
        Course course = CourseMapper.INSTANCE.courseRequestToCourseRequest(courseRequest);
        return courseRepository.save(course);
    }
}
