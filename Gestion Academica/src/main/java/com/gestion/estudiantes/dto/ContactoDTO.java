package com.gestion.estudiantes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ContactoDTO {
    private final String email;
    private final String telefono;
    private final String domicilio;
}
