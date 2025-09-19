package com.sze.studentmanagement.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "course_tb")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "course_name")
    private String courseName;
    private String description;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}
