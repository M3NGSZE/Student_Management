package com.sze.studentmanagement.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "enrollment-controller")
@RequestMapping("api/v1/enrollment")
public class EnrollmentController {
}
