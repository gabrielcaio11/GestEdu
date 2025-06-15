package br.com.gabrielcaio.gestedu.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrielcaio.gestedu.controllers.mapper.CourseMapper;
import br.com.gabrielcaio.gestedu.model.course.Course;
import br.com.gabrielcaio.gestedu.model.course.CreateCourseDTO;
import br.com.gabrielcaio.gestedu.repositories.CourseRepository;
import br.com.gabrielcaio.gestedu.validator.ValidatorCreateCourse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final ValidatorCreateCourse validatorCreateCourse;

    @Transactional(rollbackFor = Exception.class)
    public Course create(CreateCourseDTO dto) {
        // Map the DTO to the Course entity
        var course = courseMapper.toEntity(dto);

        // Validate the course entity
        validatorCreateCourse.validate(course);

        // Return the saved course entity
        return courseRepository.save(course);
    }
}