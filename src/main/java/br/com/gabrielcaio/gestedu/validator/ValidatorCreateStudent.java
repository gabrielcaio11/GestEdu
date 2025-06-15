package br.com.gabrielcaio.gestedu.validator;

import org.springframework.stereotype.Component;

import br.com.gabrielcaio.gestedu.controllers.error.BusinessException;
import br.com.gabrielcaio.gestedu.controllers.error.ResourceAlreadyExistsException;
import br.com.gabrielcaio.gestedu.model.student.Student;
import br.com.gabrielcaio.gestedu.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ValidatorCreateStudent {

    private final StudentRepository studentRepository;

    public void validate(Student student) {
        validateRegistration(student);
        validateCpf(student);
        validateEmail(student);
        validatePhoneNumber(student);
    }

    public void validateRegistration(Student student) {

        if (student.getRegistration() == null || student.getRegistration().isEmpty()) {
            throw new BusinessException("Registration cannot be null or empty");
        }

        if (studentRepository.existsByRegistration(student.getRegistration())) {
            throw new ResourceAlreadyExistsException("Registration already exists");
            
        }
    }

    public void validateCpf(Student student) {

        if (student.getCpf() == null || student.getCpf().isEmpty()) {
            throw new BusinessException("CPF cannot be null or empty");
        }

        if (studentRepository.existsByCpf(student.getCpf())) {
            throw new ResourceAlreadyExistsException("CPF already exists");
        }
    }

    public void validateEmail(Student student) {

        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            throw new BusinessException("Email cannot be null or empty");
        }

        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new ResourceAlreadyExistsException("Email already exists");
        }
    }
    
    public void validatePhoneNumber(Student student) {

        if (student.getPhoneNumber() == null || student.getPhoneNumber().isEmpty()) {
            throw new BusinessException("Phone number cannot be null or empty");
        }

        if (studentRepository.existsByPhoneNumber(student.getPhoneNumber())) {
            throw new ResourceAlreadyExistsException("Phone number already exists");
        }
    }
}
