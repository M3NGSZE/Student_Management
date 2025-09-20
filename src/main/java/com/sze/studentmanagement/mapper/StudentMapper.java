package com.sze.studentmanagement.mapper;

import com.sze.studentmanagement.model.dto.request.StudentRequest;
import com.sze.studentmanagement.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentRequest studentToStudentRequest(Student student);

    Student studentRequestToStudent(StudentRequest studentRequest);
}
