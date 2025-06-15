package br.com.gabrielcaio.gestedu.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gabrielcaio.gestedu.controllers.error.ErrorMessage;
import br.com.gabrielcaio.gestedu.controllers.mapper.CourseMapper;
import br.com.gabrielcaio.gestedu.model.course.CreateCourseDTO;
import br.com.gabrielcaio.gestedu.model.course.ResponseCourseDTO;
import br.com.gabrielcaio.gestedu.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gest-edu/courses")
@RequiredArgsConstructor
@Tag(name = "Course", description = "Operações relacionadas a Course")
public class CourseController {

        private final CourseService courseService;
        private final CourseMapper courseMapper;

        @PostMapping
        @Operation(summary = "Criar um novo Course", description = "Cria um novo curso com base nos dados fornecidos.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Course criado com sucesso", content = @Content(schema = @Schema(implementation = ResponseCourseDTO.class))),
                        @ApiResponse(responseCode = "422", description = "Dados inválidos", content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
                        @ApiResponse(responseCode = "422", description = "Course name cannot be null or empty", content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
                        @ApiResponse(responseCode = "422", description = "Course with name {name} already exists", content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
                        @ApiResponse(responseCode = "422", description = "Course code cannot be null or empty", content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
                        @ApiResponse(responseCode = "422", description = "Course with code {code} already exists", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
        })
        public ResponseEntity<ResponseCourseDTO> create(@RequestBody CreateCourseDTO dto) {
                var course = courseService.create(dto);
                var response = courseMapper.toDTO(course);

                var uri = ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(course.getId())
                                .toUri();

                return ResponseEntity
                                .created(uri)
                                .body(response);
        }
}