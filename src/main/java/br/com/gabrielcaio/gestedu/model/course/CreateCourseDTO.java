package br.com.gabrielcaio.gestedu.model.course;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para criação de um novo curso")
public class CreateCourseDTO {

    @Schema(description = "Nome do curso", example = "Ciência da Computação")
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(description = "Código do curso", example = "GRAD.00112")
    @NotBlank(message = "Code is required")
    @Pattern(regexp = "^GRAD\\.\\d{5}$", message = "Code must follow the pattern 'GRAD.XXXXX' where 'XXXXX' is a 5-digit number")
    private String code;

    @Schema(description = "Descrição do curso", example = "Curso de graduação em Ciência da Computação")
    @NotBlank(message = "Description is required")
    private String description;

    @Schema(description = "Duração do curso em horas", example = "60")
    @NotNull(message = "Duration hours is required")
    @Min(value = 1, message = "Duration hours must be greater than 0")
    @Max(value = 360, message = "Duration hours must be less than or equal to 360")
    private Integer durationHours;

    @Schema(description = "Tipo do curso", example = "BASIC_COURSE")
    @NotNull(message = "Course type is required")
    private CourseType type;
}