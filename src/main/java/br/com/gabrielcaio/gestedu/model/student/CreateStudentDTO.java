package br.com.gabrielcaio.gestedu.model.student;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import br.com.gabrielcaio.gestedu.validator.telefone.Telefone;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para criação de um novo estudante")
public class CreateStudentDTO {

    @Schema(description = "Nome completo do estudante", example = "João da Silva")
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(description = "CPF do estudante (apenas números)", example = "12345678909")
    @NotBlank(message = "CPF is required")
    @CPF(message = "Invalid CPF")
    private String cpf;

    @Schema(description = "Email do estudante", example = "joao.silva@email.com")
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = "Invalid email format")
    private String email;

    @Schema(description = "Data de nascimento do estudante no formato YYYY-MM-DD", example = "2000-01-01")
    @NotBlank(message = "Birth date is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birth date must be in YYYY-MM-DD format")
    private LocalDate birthDate;

    @Schema(description = "Número de telefone do estudante", example = "(11) 98765-4321")
    @NotBlank(message = "Phone number is required")
    @Telefone
    private String phoneNumber;
}
