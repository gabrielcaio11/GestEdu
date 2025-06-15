package br.com.gabrielcaio.gestedu.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gabrielcaio.gestedu.controllers.error.ErrorMessage;
import br.com.gabrielcaio.gestedu.controllers.mapper.StudentMapper;
import br.com.gabrielcaio.gestedu.model.student.CreateStudentDTO;
import br.com.gabrielcaio.gestedu.model.student.ResponseStudentDTO;
import br.com.gabrielcaio.gestedu.model.student.UpdateStudentStatusDTO;
import br.com.gabrielcaio.gestedu.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping("/gest-edu/students")
@RequiredArgsConstructor
@Tag(name = "Student", description = "Operações relacionadas a Student")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    // #region
    @Operation(summary = "Criar um novo student", description = "Cria um novo student com base nos dados fornecidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Estudante criado com sucesso", content = @Content(schema = @Schema(implementation = ResponseStudentDTO.class))),
            @ApiResponse(responseCode = "422", description = "Dados inválidos", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Registration cannot be null or empty", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Registration already exists", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "CPF cannot be null or empty", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "CPF already exists", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Email cannot be null or empty", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Email already exists", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Phone cannot be null or empty", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Phone already exists", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    // #endregion
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

    @GetMapping
    // #region
    @Operation(summary = "Listar todos os estudante", description = "Retorna uma lista paginada de todos os estudantes com nome e cursos associados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de estudantes retornada com sucesso", content = @Content(schema = @Schema(implementation = ResponseStudentDTO.class)))
    })
    // #endregion
    public ResponseEntity<Page<ResponseStudentDTO>> getAll(
            @Parameter(description = "Número da página (padrão: 0)", example = "0") @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
            @Parameter(description = "Tamanho da página (padrão: 10)", example = "10") @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        // instancia do pageable para a busca paginada
        var pageable = PageRequest.of(pageNumber, pageSize);

        // chama o service para a busca paginada
        var page = studentService.findAll(pageable);

        // transforma a pagina de estudante para uma pagina de estudante response
        var pageResponse = page.map(studentMapper::toDTO);

        // retorna a pagina de estudante response
        return ResponseEntity.status(HttpStatus.OK).body(pageResponse);
    }

    @GetMapping("{id}")
    // #region
    @Operation(summary = "Obter um student", description = "Retorna o student com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "student não encontrado", content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "200", description = "Detalhes do student encontrados", content = @Content(schema = @Schema(implementation = ResponseStudentDTO.class))),
    })
    // #endregion
    public ResponseEntity<ResponseStudentDTO> getById(
            @Parameter(description = "ID do student a ser buscado", required = true, example = "1") @PathVariable Long id) {
        // chama o service para buscar o estudante
        var estudanteWithCurso = studentService.getById(id);

        // tranforma de estudante para estudante response
        var response = studentMapper.toDTO(estudanteWithCurso);

        // retorna o estudante response
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("{id}/status")
    // #region
    @Operation(summary = "Atualizar status do student", description = "Atualiza o status do student com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "student não encontrado", content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "200", description = "Status do student atualizado com sucesso", content = @Content(schema = @Schema(implementation = ResponseStudentDTO.class))),
            @ApiResponse(responseCode = "422", description = "Status inválido", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    // #endregion
    public ResponseEntity<ResponseStudentDTO> updateStatus(
            @Parameter(description = "ID do estudante", required = true, example = "1") @PathVariable Long id,
            @RequestBody UpdateStudentStatusDTO dto) {
        var student = studentService.updateStatus(id, dto);
        var response = studentMapper.toDTO(student);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    // #region
    @Operation(summary = "Buscar student por matricula", description = "Busca estudantes pelo nome fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "student encontrado", content = @Content(schema = @Schema(implementation = ResponseStudentDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum student encontrado com o registration fornecido", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    })
    // #endregion
    public ResponseEntity<ResponseStudentDTO> searchByRegistration(
            @Parameter(description = "Matrícula do estudante a ser buscado", required = true, example = "2025134019") @RequestParam String registration) {
        var student = studentService.searchByRegistration(registration);
        var response = studentMapper.toDTO(student);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
