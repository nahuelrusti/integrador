package com.gestion.estudiantes.dto;

import com.gestion.estudiantes.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CursoDTO {
    private final String nombre;
    private final Instructor instructorFk;
}
