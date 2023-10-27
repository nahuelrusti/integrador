package com.gestion.estudiantes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EstudianteDTO {
    private final String nombreCompleto;
    private final String dni;
    private final String curso;
    private final Integer fechaNacimiento;
}
