package com.gestion.estudiantes.dto;

import com.gestion.estudiantes.entity.Contacto;
import com.gestion.estudiantes.entity.Estudiante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ContactoDTO {
    private final String email;
    private final String telefono;
    private final String domicilio;

    public ContactoDTO(String email, String telefono, Contacto c){
        this.email = email;
        this.telefono = telefono;
        this.domicilio = c.getProvincia().
                concat(" - ").concat(c.getCiudad()).
                concat(" - ").concat(c.getDireccion()).
                concat(" - ").concat(c.getCodigoPostal());
    }
}
