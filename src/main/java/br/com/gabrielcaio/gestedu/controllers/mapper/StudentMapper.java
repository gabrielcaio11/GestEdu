package br.com.gabrielcaio.gestedu.controllers.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import br.com.gabrielcaio.gestedu.model.student.CreateStudentDTO;
import br.com.gabrielcaio.gestedu.model.student.ResponseStudentDTO;
import br.com.gabrielcaio.gestedu.model.student.Student;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface StudentMapper {   
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registration", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Student toEntity(CreateStudentDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registration", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDTO(CreateStudentDTO dto, @MappingTarget Student student);

    ResponseStudentDTO toDTO(Student student);
}
