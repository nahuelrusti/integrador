package com.gestion.estudiantes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Data
//Getters and Setters

@Entity(name = "estudiantes")
@Table
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //autoincremento
    private long id;

    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String curso;

    @Column(name = "nacimiento", nullable = false)
   private LocalDate fechaNacimiento;

    @ManyToMany
    @JoinTable(name = "curso_estudiantes",
            joinColumns = @JoinColumn(name = "id_curso", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_estudiante", referencedColumnName = "id"))
    private List<Curso> cursos;

    @CreationTimestamp
    private LocalDateTime creacion;

    @UpdateTimestamp
    private LocalDateTime modificacion;
}
