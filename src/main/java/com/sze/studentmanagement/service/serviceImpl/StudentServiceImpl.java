package com.sze.studentmanagement.service.serviceImpl;

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

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
