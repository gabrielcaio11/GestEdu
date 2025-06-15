package br.com.gabrielcaio.gestedu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabrielcaio.gestedu.model.course.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByName(String name);

    boolean existsByCode(String code);
}