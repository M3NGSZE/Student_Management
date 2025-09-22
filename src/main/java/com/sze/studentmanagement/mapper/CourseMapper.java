package com.sze.studentmanagement.mapper;

import com.sze.studentmanagement.model.dto.request.CourseRequest;
import com.sze.studentmanagement.model.dto.response.CourseResponse;
import com.sze.studentmanagement.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    Course courseRequestToCourse(CourseRequest courseRequest);

    CourseRequest courseRequestToCourseRequest(Course course);

    List<CourseResponse> courseListToCourseResponseList(List<Course> courseList);

    CourseResponse courseRequestToCourseResponse(Course course);
}
