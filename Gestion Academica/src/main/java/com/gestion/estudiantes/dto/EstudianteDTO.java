package com.gestion.estudiantes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class EstudianteDTO {
    private final String nombre;
    private final String apellido;
    private final String dni;
    private final String curso;
    private final LocalDateTime fechaNacimiento;
}
