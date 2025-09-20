package com.sze.studentmanagement.repository;

import com.sze.studentmanagement.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
