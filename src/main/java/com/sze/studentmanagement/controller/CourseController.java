package com.sze.studentmanagement.controller;

import com.sze.studentmanagement.model.dto.response.ApiResponse;
import com.sze.studentmanagement.model.entity.Student;
import com.sze.studentmanagement.repository.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Tag(name = "students-controller")
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class CourseController {
    private final StudentRepository studentRepository;

    @GetMapping
    @Operation(summary = "get all student")
    public ResponseEntity<ApiResponse<List<Student>>> getStudents() {

        List<Student> students = studentRepository.findAll();
        ApiResponse<List<Student>> apiResponse = ApiResponse.<List<Student>>builder()
                .message("All attendees have been successfully fetched.")
                .payload(students)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
