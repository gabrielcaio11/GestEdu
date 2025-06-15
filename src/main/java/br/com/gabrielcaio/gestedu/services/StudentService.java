package br.com.gabrielcaio.gestedu.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrielcaio.gestedu.controllers.mapper.StudentMapper;
import br.com.gabrielcaio.gestedu.model.student.CreateStudentDTO;
import br.com.gabrielcaio.gestedu.model.student.Student;
import br.com.gabrielcaio.gestedu.repositories.StudentRepository;
import br.com.gabrielcaio.gestedu.util.StudentRegistrationGenerator;
import br.com.gabrielcaio.gestedu.validator.ValidatorCreateStudent;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ValidatorCreateStudent validatorCreateStudent;
    private final StudentRegistrationGenerator registrationGenerator;

    @Transactional(rollbackFor = Exception.class)
    public Student create(CreateStudentDTO dto) {
        // Map the DTO to the Student entity
        var student = studentMapper.toEntity(dto);

        // Generate the registration for the student
        registrationGenerator.generateRegistration(student);

        // Validate the student entity
        validatorCreateStudent.validate(student);

        // Return the saved student entity
        return studentRepository.save(student);
    }

    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
}
