package com.gestion.estudiantes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data

@Entity(name = "Calificaciones")
@Table
public class Calificacion extends EntitySuper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id")
    private Estudiante estudianteFk;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_instructor", referencedColumnName = "id")
    private Instructor instructorFk;

    @Column(nullable = false)
    private Integer nota;
}
