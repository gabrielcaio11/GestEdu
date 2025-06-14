package br.com.gabrielcaio.gestedu.controllers.mapper;

import org.mapstruct.Mapper;

import br.com.gabrielcaio.gestedu.model.student.CreateStudentDTO;
import br.com.gabrielcaio.gestedu.model.student.ResponseStudentDTO;
import br.com.gabrielcaio.gestedu.model.student.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {   
    Student toEntity(CreateStudentDTO dto);
    ResponseStudentDTO toDTO(Student student);
}
