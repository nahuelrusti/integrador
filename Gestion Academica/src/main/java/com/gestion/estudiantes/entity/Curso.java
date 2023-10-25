package com.gestion.estudiantes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor

@Data

@Entity(name = "cursos")
@Table
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    //Foreign Key Instructor id, se quitó que sea obligatorio
    @ManyToOne
    @JoinColumn(name="id_instructor", referencedColumnName = "id")
    private Instructor instructorFk;

    @CreationTimestamp
    private LocalDateTime creacion;

    @UpdateTimestamp
    private LocalDateTime modificacion;

}
