package com.gestion.estudiantes.dto;

import com.gestion.estudiantes.entity.Estudiante;
import com.gestion.estudiantes.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CalificacionDTO {
    private Estudiante estudianteFk;
    private Instructor instructorFk;
    private Integer nota;
}
