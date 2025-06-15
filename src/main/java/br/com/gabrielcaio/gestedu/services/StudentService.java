package br.com.gabrielcaio.gestedu.services;

import java.util.Arrays;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrielcaio.gestedu.controllers.error.ResourceNotFoundException;
import br.com.gabrielcaio.gestedu.controllers.mapper.StudentMapper;
import br.com.gabrielcaio.gestedu.model.student.CreateStudentDTO;
import br.com.gabrielcaio.gestedu.model.student.Student;
import br.com.gabrielcaio.gestedu.model.student.StudentStatus;
import br.com.gabrielcaio.gestedu.model.student.UpdateStudentStatusDTO;
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

        // Set the initial status of the student
        student.statusActive();

        // Generate the registration for the student
        registrationGenerator.generateRegistration(student);

        // Validate the student entity
        validatorCreateStudent.validate(student);

        // Return the saved student entity
        return studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Student getById(Long id) {
        return studentRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    @Transactional(rollbackFor = Exception.class)
    public Student updateStatus(Long id, UpdateStudentStatusDTO dto) {
        var student = getById(id);
        var status = getStatus(dto.getStatus());
        student.updateStatus(status);
        return studentRepository.save(student);
    }

    private StudentStatus getStatus(String status) {
        isValidStatus(status);
        return StudentStatus.valueOf(status);
    }

    private void isValidStatus(String status) {
        final String upperStatus = status.toUpperCase();
        Arrays.stream(StudentStatus.values())
            .filter(s -> s.name().equals(upperStatus))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Invalid status: " + upperStatus));
    }

    @Transactional(readOnly = true)
    public Student searchByRegistration(String registration) {
        return studentRepository.findByRegistration(registration)
                .orElseThrow(() -> new ResourceNotFoundException("No student found with registration: " + registration));
       
    }
}
