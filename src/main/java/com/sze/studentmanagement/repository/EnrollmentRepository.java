package com.sze.studentmanagement.repository;

import com.sze.studentmanagement.model.dto.response.EnrollmentCourseResponse;
import com.sze.studentmanagement.model.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

//    Enrollment getEnrollmentByStudentId(Long studentId);

    List<Enrollment> findByStudent_StudentId(Long studentId);

}
