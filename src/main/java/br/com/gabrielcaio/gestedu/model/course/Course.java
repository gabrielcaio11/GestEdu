package br.com.gabrielcaio.gestedu.model.course;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "tb_courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners({ AuditingEntityListener.class })
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "name", unique = true)
    private String name;

    @Column(nullable = false, name = "code", unique = true)
    private String code;

    @Column(nullable = false, name = "description")
    private String description;

    @Column(nullable = false, name = "duration_hours")
    private Integer durationHours;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "type")
    private CourseType type;

    @Column(nullable = false, name = "is_active")
    private Boolean isActive;

    @Column(updatable = false, name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;
}