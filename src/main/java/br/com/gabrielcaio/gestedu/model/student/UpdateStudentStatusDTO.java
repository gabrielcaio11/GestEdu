package br.com.gabrielcaio.gestedu.model.student;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para atualização do status do estudante")
public class UpdateStudentStatusDTO {
    
    @Schema(description = "Novo status do estudante", example = "ACTIVE")
    @NotNull(message = "Status is required")
    private String status;
} 