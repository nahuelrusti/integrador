package com.gestion.estudiantes.dto;

import com.gestion.estudiantes.entity.Estudiante;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ContactoDTO {
    private final String email;
    private final String telefono;
    private final String direccion;
    private final String ciudad;
    private final String provincia;
    private final String codigopostal;
    private final Estudiante estudianteFk;
}
