package com.sze.studentmanagement.controller;

import com.sze.studentmanagement.model.dto.request.CourseRequest;
import com.sze.studentmanagement.model.dto.response.ApiResponse;
import com.sze.studentmanagement.model.dto.response.CourseResponse;
import com.sze.studentmanagement.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ApiResponse<List<CourseResponse>>> getALlCourses() {

        List<CourseResponse> courses = courseService.getAllCourses();

        ApiResponse<List<CourseResponse>> apiResponse = ApiResponse.<List<CourseResponse>>builder()
                .message("All courses have been successfully fetched.")
                .payload(courses)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping
    @Operation(summary = "add new course")
    public ResponseEntity<ApiResponse<CourseResponse>> createCourse(@RequestBody CourseRequest courseRequest) {

        CourseResponse courses = courseService.createCourses(courseRequest);

        ApiResponse<CourseResponse> apiResponse = ApiResponse.<CourseResponse>builder()
                .message("new course has been successfully created.")
                .payload(courses)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{course-id}")
    @Operation(summary = "update course")
    public ResponseEntity<ApiResponse<CourseResponse>> updateCourse(@PathVariable("course-id") Long id,@RequestBody CourseRequest courseRequest) {

        CourseResponse courses = courseService.updateCourses(id, courseRequest);

        ApiResponse<CourseResponse> apiResponse = ApiResponse.<CourseResponse>builder()
                .message("Course has been successfully updated.")
                .payload(courses)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/{course-id}")
    @Operation(summary = "get course by id")
    public ResponseEntity<ApiResponse<CourseResponse>> getCourseById(@PathVariable("course-id") Long id) {

        CourseResponse courses = courseService.getCourseById(id);

        ApiResponse<CourseResponse> apiResponse = ApiResponse.<CourseResponse>builder()
                .message("Course has been successfully founded.")
                .payload(courses)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("/{course-id}")
    @Operation(summary = "get course by id")
    public ResponseEntity<ApiResponse<CourseResponse>> deleteCourseById(@PathVariable("course-id") Long id) {

        CourseResponse courses = courseService.deleteCourses(id);

        ApiResponse<CourseResponse> apiResponse = ApiResponse.<CourseResponse>builder()
                .message("Course has been successfully deleted.")
                .payload(courses)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }


}
