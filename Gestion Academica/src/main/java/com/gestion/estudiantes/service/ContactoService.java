package com.gestion.estudiantes.service;

import com.gestion.estudiantes.dto.ContactoDTO;
import com.gestion.estudiantes.entity.Contacto;

import java.util.List;

public interface ContactoService {

    Contacto saveContacto(Contacto c);

    Contacto modificarContacto(Contacto contacto, Long id);

    void deleteContactoById(Long id);

    List<ContactoDTO> findContacto();

    ContactoDTO findContactoById(Long id);

}
