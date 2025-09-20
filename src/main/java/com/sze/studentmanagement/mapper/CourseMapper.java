package com.sze.studentmanagement.mapper;

import com.sze.studentmanagement.model.dto.request.CourseRequest;
import com.sze.studentmanagement.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    Course courseRequestToCourseRequest(CourseRequest courseRequest);

    CourseRequest courseRequestToCourseRequest(Course course);
}
