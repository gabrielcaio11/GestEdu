package br.com.gabrielcaio.gestedu.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrielcaio.gestedu.controllers.mapper.StudentMapper;
import br.com.gabrielcaio.gestedu.model.student.CreateStudentDTO;
import br.com.gabrielcaio.gestedu.model.student.Student;
import br.com.gabrielcaio.gestedu.repositories.StudentRepository;
import br.com.gabrielcaio.gestedu.validator.ValidatorCreateStudent;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ValidatorCreateStudent validatorCreateStudent;

    @Transactional(rollbackFor = Exception.class)
    public Student create(CreateStudentDTO dto) {

        // MAp the DTO to the Student entity
        var student = studentMapper.toEntity(dto);

        // Build the registration for the student
        student.buildRegistration();

        // Validate the student entity
        validatorCreateStudent.validate(student);

        // retorn the saved student entity
        return studentRepository.save(student);
    }

}
