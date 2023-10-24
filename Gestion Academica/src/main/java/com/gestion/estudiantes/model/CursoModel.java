package com.gestion.estudiantes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Data

@Entity(name = "cursos")
@Table
public class CursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    //Foreign Key Instructor id, se quitó que sea obligatorio
    @ManyToOne
    @JoinColumn(name="id_instructor", referencedColumnName = "id")
    private InstructorModel instructorFk;

}
