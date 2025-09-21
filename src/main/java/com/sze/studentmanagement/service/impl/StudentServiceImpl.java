package com.sze.studentmanagement.service.impl;

import com.sze.studentmanagement.exception.NotFoundExceptionHandler;
import com.sze.studentmanagement.mapper.StudentMapper;
import com.sze.studentmanagement.model.dto.request.StudentRequest;
import com.sze.studentmanagement.model.dto.response.StudentResponse;
import com.sze.studentmanagement.model.entity.Student;
import com.sze.studentmanagement.repository.StudentRepository;
import com.sze.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<StudentResponse> findAll() {
        return StudentMapper.INSTANCE.studentListToStudentResponseList(studentRepository.findAll());
    }

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = StudentMapper.INSTANCE.studentRequestToStudent(studentRequest);

        Student newStudent = studentRepository.save(student);

        return StudentMapper.INSTANCE.studentToStudentResponse(newStudent);
    }

    @Override
    public StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) {

        studentRepository.findById(studentId).orElseThrow(() -> new NotFoundExceptionHandler("Student not found with id " + studentId));

        Student student = StudentMapper.INSTANCE.studentRequestToStudent(studentRequest);
        student.setStudentId(studentId);

        Student updateStudent = studentRepository.save(student);

        return StudentMapper.INSTANCE.studentToStudentResponse(updateStudent);
    }
}
