package br.com.gabrielcaio.gestedu.model.student;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO de resposta com os dados do estudante")
public class ResponseStudentDTO {
    
    @Schema(description = "Nome completo do estudante", example = "João da Silva")
    private String name;

    @Schema(description = "CPF do estudante", example = "123.456.789-09")
    private String cpf;

    @Schema(description = "Matrícula do estudante", example = "2024001")
    private String registration;

    @Schema(description = "Email do estudante", example = "joao.silva@email.com")
    private String email;

    @Schema(description = "Data de nascimento do estudante", example = "2000-01-01")
    private LocalDate birthDate;

    @Schema(description = "Número de telefone do estudante", example = "(11) 98765-4321")
    private String phoneNumber;

    @Schema(description = "Status do estudante", example = "ACTIVE")
    private StudentStatus status;
}
