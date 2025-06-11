package br.com.gabrielcaio.gestedu.model.student;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import br.com.gabrielcaio.gestedu.validator.telefone.Telefone;
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
public class CreateStudentDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "CPF is required")
    @CPF(message = "Invalid CPF")
    private String cpf;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = "Invalid email format")
    private String email;

    @NotBlank(message = "Birth date is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birth date must be in YYYY-MM-DD format")
    private LocalDate birthDate;

    @NotBlank(message = "Phone number is required")
    @Telefone
    private String phoneNumber;
}
