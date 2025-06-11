package br.com.gabrielcaio.gestedu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabrielcaio.gestedu.model.student.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByRegistration(String registration);
    boolean existsByEmail(String email);
} 