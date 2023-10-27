package com.gestion.estudiantes.service;

import com.gestion.estudiantes.entity.Contacto;

import java.util.List;

public interface ContactoService {

    Contacto saveContacto(Contacto c);

    void deleteContactoById(Long id);

    List<Contacto> findContacto();

    Contacto findContactoById(Long id);

}
