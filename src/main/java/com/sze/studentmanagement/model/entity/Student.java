package com.sze.studentmanagement.model.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "student_tb")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
}
