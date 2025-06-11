package br.com.gabrielcaio.gestedu.model.student;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStudentDTO {
    private String name;
    private String cpf;
    private String registration;
    private String email;
    private LocalDate birthDate;
    private String phoneNumber;
}
