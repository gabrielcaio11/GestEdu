package br.com.gabrielcaio.gestedu.model.course;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO de resposta com os dados do curso")
public class ResponseCourseDTO {

    @Schema(description = "Nome do curso", example = "Ciência da Computação")
    private String name;

    @Schema(description = "Código do curso", example = "CC001")
    private String code;

    @Schema(description = "Descrição do curso", example = "Curso de graduação em Ciência da Computação")
    private String description;

    @Schema(description = "Duração do curso em horas", example = "3600")
    private Integer durationHours;

    @Schema(description = "Tipo do curso", example = "BASIC_COURSE")
    private CourseType type;

    @Schema(description = "Status de ativação do curso", example = "true")
    private Boolean isActive;
}