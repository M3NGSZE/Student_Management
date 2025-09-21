package com.sze.studentmanagement.service;

import com.sze.studentmanagement.model.dto.request.StudentRequest;
import com.sze.studentmanagement.model.dto.response.StudentResponse;
import com.sze.studentmanagement.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentResponse> findAll();
    Student createStudent(StudentRequest studentRequest);
}
