package com.sze.studentmanagement.service.impl;

import com.sze.studentmanagement.exception.NotFoundExceptionHandler;
import com.sze.studentmanagement.mapper.CourseMapper;
import com.sze.studentmanagement.model.dto.request.CourseRequest;
import com.sze.studentmanagement.model.dto.response.CourseResponse;
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
    public List<CourseResponse> getAllCourses() {
        List<Course> allCourses = courseRepository.findAll();
        return CourseMapper.INSTANCE.courseListToCourseResponseList(allCourses);
    }

    @Override
    public CourseResponse createCourses(CourseRequest courseRequest) {
        Course course = CourseMapper.INSTANCE.courseRequestToCourse(courseRequest);
        Course newCourse = courseRepository.save(course);
        return CourseMapper.INSTANCE.courseRequestToCourseResponse(newCourse);
    }

    // one line code but hard to read
    @Override
    public CourseResponse updateCourses(Long courseId,CourseRequest courseRequest) {

        courseRepository.findById(courseId).orElseThrow(() -> new NotFoundExceptionHandler("course not founded with id " + courseId));

        Course course = CourseMapper.INSTANCE.courseRequestToCourse(courseRequest);
        course.setCourseId(courseId);

        return CourseMapper.INSTANCE.courseRequestToCourseResponse(
                courseRepository.save(course)
        );
    }

    @Override
    public CourseResponse getCourseById(Long courseId) {
        return CourseMapper.INSTANCE.courseRequestToCourseResponse(
                courseRepository.findById(courseId).orElseThrow(() -> new NotFoundExceptionHandler("course not founded with id " + courseId))
        );
    }

    @Override
    public CourseResponse deleteCourses(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NotFoundExceptionHandler("course not founded with id " + courseId));

        courseRepository.deleteById(courseId);

        return CourseMapper.INSTANCE.courseRequestToCourseResponse(course);
    }
}

