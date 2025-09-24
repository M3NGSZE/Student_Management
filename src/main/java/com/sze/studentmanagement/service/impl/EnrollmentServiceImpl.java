package com.sze.studentmanagement.service.impl;

import com.sze.studentmanagement.exception.NotFoundExceptionHandler;
import com.sze.studentmanagement.mapper.CourseMapper;
import com.sze.studentmanagement.mapper.StudentMapper;
import com.sze.studentmanagement.model.dto.response.CourseResponse;
import com.sze.studentmanagement.model.dto.response.EnrollmentCourseResponse;
import com.sze.studentmanagement.model.dto.response.StudentResponse;
import com.sze.studentmanagement.model.entity.Course;
import com.sze.studentmanagement.model.entity.Enrollment;
import com.sze.studentmanagement.model.entity.Student;
import com.sze.studentmanagement.repository.CourseRepository;
import com.sze.studentmanagement.repository.EnrollmentRepository;
import com.sze.studentmanagement.repository.StudentRepository;
import com.sze.studentmanagement.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public EnrollmentCourseResponse getEnrollmentByStudentId(Long studentId) {

        List<Enrollment> enrollments = enrollmentRepository.findByStudent_StudentId(studentId);

        if (enrollments.isEmpty()) {
            throw new NotFoundExceptionHandler("enrollment not found with studentId: " + studentId);
        }

        Student student = enrollments.getFirst().getStudent();
        StudentResponse studentResponse = StudentMapper.INSTANCE.studentToStudentResponse(student);

        List<Course> courses = enrollments.stream()
                .map(Enrollment::getCourse)
                .toList();

        List<CourseResponse> courseResponses = CourseMapper.INSTANCE.courseListToCourseResponseList(courses);


        return new EnrollmentCourseResponse(studentResponse, courseResponses);
    }

    @Override
    public EnrollmentCourseResponse addEnrollmentByStudentId(Long studentId, List<Long> courseIds) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundExceptionHandler("Student not found with id: " + studentId));

        List<Course> courses = courseRepository.findAllById(courseIds);

        if (courses.isEmpty()) {
            throw new NotFoundExceptionHandler("No courses found for the provided IDs");
        }

//        List<Enrollment> enrollments = new ArrayList<>();
//        for (Course course : courses) {
//            Enrollment enrollment = new Enrollment();
//            enrollment.setStudent(student);
//            enrollment.setCourse(course);
//            enrollments.add(enrollment);
//        }

        List<Enrollment> enrollments = courses.stream()
                .map(course -> {
                    Enrollment enrollment = new Enrollment();
                    enrollment.setStudent(student);
                    enrollment.setCourse(course);
                    return enrollment;
                })
                .collect(Collectors.toList());



        enrollmentRepository.saveAll(enrollments);

        // 4️⃣ Map to DTOs
        StudentResponse studentResponse = StudentMapper.INSTANCE.studentToStudentResponse(student);
        List<CourseResponse> courseResponses = CourseMapper.INSTANCE.courseListToCourseResponseList(courses);


        return new EnrollmentCourseResponse(studentResponse, courseResponses);
    }


}
