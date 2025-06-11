package br.com.gabrielcaio.gestedu.model.student;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners({AuditingEntityListener.class})
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false,name = "cpf", unique = true)
    private String cpf;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, unique = true, name = "registration")
    private String registration;

    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @Column(nullable = false,name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(updatable = false, name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void buildRegistration() {
        var randomNumber1 = (int) (Math.random() * 90) + 10;
        var randomNumber2 = (int) (Math.random() * 90) + 10;
        this.registration = String.format("%d%d-%d%d", LocalDate.now().getYear(), this.name.length(), randomNumber1, randomNumber2);
    }
} 