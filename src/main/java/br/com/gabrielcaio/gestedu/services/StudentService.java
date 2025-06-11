package br.com.gabrielcaio.gestedu.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrielcaio.gestedu.mapper.StudentMapper;
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

    @Transactional
    public Student create(CreateStudentDTO dto) {

        // Transforma de dto para entidade
        var student = studentMapper.toEntity(dto);

        // validacao da criação do estudante
        validatorCreateStudent.validate(student);

        // chama o metodo para constrir o registration
        student.buildRegistration();

        // retorna o estudante salvo
        return studentRepository.save(student);
    }

}
