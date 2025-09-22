package com.sze.studentmanagement.controller;

import com.sze.studentmanagement.model.dto.request.StudentRequest;
import com.sze.studentmanagement.model.dto.response.ApiResponse;
import com.sze.studentmanagement.model.dto.response.StudentResponse;
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
    @Operation(summary = "get all students")
    public ResponseEntity<ApiResponse<List<StudentResponse>>> getStudents() {
        List<StudentResponse> students = studentService.findAll();

        ApiResponse<List<StudentResponse>> apiResponse = ApiResponse.<List<StudentResponse>>builder()
                .message("")
                .payload(students)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    @Operation(summary = "add new student")
    public ResponseEntity<ApiResponse<StudentResponse>> getStudents(@RequestBody StudentRequest studentRequest) {

        StudentResponse newStudent = studentService.createStudent(studentRequest);

        ApiResponse<StudentResponse> apiResponse = ApiResponse.<StudentResponse>builder()
                .message("new student has been successfully created.")
                .payload(newStudent)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{studentId}")
    @Operation(summary = "update student by id")
    public ResponseEntity<ApiResponse<StudentResponse>> updateStudent(@PathVariable Long studentId ,@RequestBody StudentRequest studentRequest) {

        StudentResponse studentResponse = studentService.updateStudent(studentId, studentRequest);

        ApiResponse<StudentResponse> apiResponse = ApiResponse.<StudentResponse>builder()
                .message("student has been successfully updated.")
                .payload(studentResponse)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{studentId}")
    @Operation(summary = "get student by id")
    public ResponseEntity<ApiResponse<StudentResponse>> findStudentById(@PathVariable Long studentId) {

        StudentResponse studentResponse = studentService.findStudentById(studentId);

        ApiResponse<StudentResponse> apiResponse = ApiResponse.<StudentResponse>builder()
                .message("student has been successfully founded.")
                .payload(studentResponse)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{studentId}")
    @Operation(summary = "get student by id")
    public ResponseEntity<ApiResponse<StudentResponse>> deleteStudentById(@PathVariable Long studentId) {

        StudentResponse studentResponse = studentService.deleteStudent(studentId);

        ApiResponse<StudentResponse> apiResponse = ApiResponse.<StudentResponse>builder()
                .message("student has been successfully deleted.")
                .payload(studentResponse)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }


}
