package com.sze.studentmanagement.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Long courseId;
    @Column(name = "course_name")
    private String courseName;
    private String description;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments = new ArrayList<>();

}

//    @ManyToMany(mappedBy = "courses")
////    @JsonManagedReference
////    @JsonIgnore
//    private List<Student> students = new ArrayList<>();
