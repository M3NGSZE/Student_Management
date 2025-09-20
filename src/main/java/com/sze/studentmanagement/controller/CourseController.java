package com.sze.studentmanagement.controller;

import com.sze.studentmanagement.model.dto.response.ApiResponse;
import com.sze.studentmanagement.model.entity.Course;
import com.sze.studentmanagement.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Tag(name = "courses-controller")
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    @Operation(summary = "get all course")
    public ResponseEntity<ApiResponse<List<Course>>> getStudents() {

        List<Course> courses = courseService.getAllCourses();

        System.out.println(courses);

        ApiResponse<List<Course>> apiResponse = ApiResponse.<List<Course>>builder()
                .message("All courses have been successfully fetched.")
                .payload(courses)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping
    @Operation(summary = "add new course")
    public ResponseEntity<ApiResponse<Course>> getStudents(Course course) {

        Course courses = courseService.createCourses(course);


        ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                .message("new course has been successfully created.")
                .payload(courses)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }


}
