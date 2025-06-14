package br.com.gabrielcaio.gestedu.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gabrielcaio.gestedu.controllers.mapper.StudentMapper;
import br.com.gabrielcaio.gestedu.model.student.CreateStudentDTO;
import br.com.gabrielcaio.gestedu.model.student.ResponseStudentDTO;
import br.com.gabrielcaio.gestedu.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gest-edu/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    @Operation(summary = "Criar um novo student", description = "Cria um novo student com base nos dados fornecidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Estudante criado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados inválidos"),
            @ApiResponse(responseCode = "422", description = "Registration cannot be null or empty"),
            @ApiResponse(responseCode = "422", description = "Registration already exists"),
            @ApiResponse(responseCode = "422", description = "CPF cannot be null or empty"),
            @ApiResponse(responseCode = "422", description = "CPF already exists"),
            @ApiResponse(responseCode = "422", description = "Email cannot be null or empty"),
            @ApiResponse(responseCode = "422", description = "Email already exists"),
            @ApiResponse(responseCode = "422", description = "Phone cannot be null or empty"),
            @ApiResponse(responseCode = "422", description = "Phone already exists"),
    })
    public ResponseEntity<ResponseStudentDTO> create(@RequestBody CreateStudentDTO dto) {
        var student = studentService.create(dto);
        var response = studentMapper.toDTO(student);
        
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getId())
                .toUri();
                
        return ResponseEntity
                .created(uri)
                .body(response);
    }
}
