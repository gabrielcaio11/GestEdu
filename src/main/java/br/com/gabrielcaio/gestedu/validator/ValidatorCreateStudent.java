package br.com.gabrielcaio.gestedu.validator;

import org.springframework.stereotype.Component;

import br.com.gabrielcaio.gestedu.controllers.error.BusinessException;
import br.com.gabrielcaio.gestedu.model.student.Student;
import br.com.gabrielcaio.gestedu.repositories.StudentRepository;

@Component
public class ValidatorCreateStudent {

    private final StudentRepository studentRepository;
    
    public ValidatorCreateStudent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void validate(Student student) {
        validateRegistration(student);
        validateCpf(student);
        validateEmail(student);
        validatePhoneNumber(student);
    }

    public void validateRegistration(Student student) {

        // Validates the student's registration
        if (student.getRegistration() == null || student.getRegistration().isEmpty()) {
            throw new BusinessException("Registration cannot be null or empty");
        }

        // Checks if the registration already exists in the database
        if (studentRepository.existsByRegistration(student.getRegistration())) {
            throw new BusinessException("Registration already exists");
            
        }

    }

    public void validateCpf(Student student) {

        // Validates the student's CPF
        if (student.getCpf() == null || student.getCpf().isEmpty()) {
            throw new BusinessException("CPF cannot be null or empty");
        }

        // Checks if the CPF already exists in the database
        if (studentRepository.existsByCpf(student.getCpf())) {
            throw new BusinessException("CPF already exists");
        }
    }
    public void validateEmail(Student student) {

        // Validates the student's email
        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            throw new BusinessException("Email cannot be null or empty");
        }

        // Checks if the email already exists in the database
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new BusinessException("Email already exists");
        }
    }
    public void validatePhoneNumber(Student student) {

        // Validates the student's phone number
        if (student.getPhoneNumber() == null || student.getPhoneNumber().isEmpty()) {
            throw new BusinessException("Phone number cannot be null or empty");
        }

        // Checks if the phone number already exists in the database
        if (studentRepository.existsByPhoneNumber(student.getPhoneNumber())) {
            throw new BusinessException("Phone number already exists");
        }
    }
}
