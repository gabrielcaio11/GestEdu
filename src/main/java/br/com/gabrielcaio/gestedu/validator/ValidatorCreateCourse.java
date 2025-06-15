package br.com.gabrielcaio.gestedu.validator;

import org.springframework.stereotype.Component;

import br.com.gabrielcaio.gestedu.controllers.error.BusinessException;
import br.com.gabrielcaio.gestedu.controllers.error.ResourceAlreadyExistsException;
import br.com.gabrielcaio.gestedu.model.course.Course;
import br.com.gabrielcaio.gestedu.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ValidatorCreateCourse {

    private final CourseRepository courseRepository;

    public void validate(Course course) {
        validateName(course.getName());
        validateCode(course.getCode());
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }
        if (courseRepository.existsByName(name)) {
            throw new ResourceAlreadyExistsException("Course with name " + name + " already exists");
        }
    }

    private void validateCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty");
        }
        if (courseRepository.existsByCode(code)) {
            throw new ResourceAlreadyExistsException("Course with code " + code + " already exists");
        }
    }

}
