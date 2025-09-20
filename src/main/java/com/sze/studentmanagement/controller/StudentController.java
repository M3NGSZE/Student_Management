package com.sze.studentmanagement.controller;

import com.sze.studentmanagement.model.dto.request.StudentRequest;
import com.sze.studentmanagement.model.dto.response.ApiResponse;
import com.sze.studentmanagement.model.entity.Course;
import com.sze.studentmanagement.model.entity.Student;
import com.sze.studentmanagement.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Tag(name = "student-controller")
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getStudents() {
        List<Student> students = studentService.findAll();

        ApiResponse<List<Student>> apiResponse = ApiResponse.<List<Student>>builder()
                .message("")
                .payload(students)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    @Operation(summary = "add new course")
    public ResponseEntity<ApiResponse<Student>> getStudents(@RequestBody StudentRequest studentRequest) {

        Student newStudent = studentService.createStudent(studentRequest);

        ApiResponse<Student> apiResponse = ApiResponse.<Student>builder()
                .message("new student has been successfully created.")
                .payload(newStudent)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
