package br.com.gabrielcaio.gestedu.controllers.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import br.com.gabrielcaio.gestedu.model.course.Course;
import br.com.gabrielcaio.gestedu.model.course.CreateCourseDTO;
import br.com.gabrielcaio.gestedu.model.course.ResponseCourseDTO;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", constant = "true")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Course toEntity(CreateCourseDTO dto);

    ResponseCourseDTO toDTO(Course course);
}