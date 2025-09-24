package com.sze.studentmanagement.controller;

import com.sze.studentmanagement.model.dto.response.ApiResponse;
import com.sze.studentmanagement.model.dto.response.EnrollmentCourseResponse;
import com.sze.studentmanagement.model.entity.Enrollment;
import com.sze.studentmanagement.service.EnrollmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Tag(name = "enrollment-controller")
@RequestMapping("api/v1/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping("{student-id}")
    @Operation(summary = "get enrollment course by student id")
    public ResponseEntity<ApiResponse<EnrollmentCourseResponse>> getCourseByStudentId(@PathVariable("student-id") Long id) {
        EnrollmentCourseResponse enrollmentByStudentId = enrollmentService.getEnrollmentByStudentId(id);

        ApiResponse<EnrollmentCourseResponse> apiResponse = ApiResponse.<EnrollmentCourseResponse>builder()
                .message("")
                .payload(enrollmentByStudentId)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
