package com.sze.studentmanagement.repository;

import com.sze.studentmanagement.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
