package com.sze.studentmanagement.service.impl;

import com.sze.studentmanagement.mapper.StudentMapper;
import com.sze.studentmanagement.model.dto.request.StudentRequest;
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
//    private final StudentMapper studentMapper;



    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(StudentRequest studentRequest) {
//        Student student = studentMapper.studentRequestToStudent(studentRequest);
        Student student = StudentMapper.INSTANCE.studentRequestToStudent(studentRequest);

        return studentRepository.save(student);
    }
}
