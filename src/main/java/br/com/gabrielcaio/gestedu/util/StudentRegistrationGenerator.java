package br.com.gabrielcaio.gestedu.util;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Component;

import br.com.gabrielcaio.gestedu.model.student.Student;

@Component
public class StudentRegistrationGenerator {
    
    private final Random random;

    public StudentRegistrationGenerator() {
        this.random = new Random();
    }

    public void generateRegistration(Student student) {
        if (student == null || student.getName() == null) {
            throw new IllegalArgumentException("Student and student name cannot be null");
        }

        int randomNumber1 = random.nextInt(90) + 10; // Gera número entre 10 e 99
        int randomNumber2 = random.nextInt(90) + 10; // Gera número entre 10 e 99
        
        String registration = String.format("%d%d%d%d", 
            LocalDate.now().getYear(),
            student.getName().length(),
            randomNumber1,
            randomNumber2
        );

        student.setRegistration(registration);
    }
} 