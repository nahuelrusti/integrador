package com.gestion.estudiantes.controller;

import com.gestion.estudiantes.dto.ContactoDTO;
import com.gestion.estudiantes.entity.Contacto;
import com.gestion.estudiantes.servicesImpl.ContactoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ContactoController {
    @Autowired
    private ContactoServiceImpl contactoServiceImpl;
    //Acá estaba el repository

    @PostMapping("/contactos/nuevo")
    public Contacto nuevoContacto(@RequestBody Contacto contactoNuevo){
        return contactoServiceImpl.saveContacto(contactoNuevo);
    }

    @PutMapping("/contactos/{id}")
    public Contacto editarContacto(@RequestBody Contacto contacto, @PathVariable Long id){
        return contactoServiceImpl.modificarContacto(contacto, id);
    }

    @DeleteMapping("/contactos/{id}")
    public void eliminarContacto(@PathVariable Long id) {
        contactoServiceImpl.deleteContactoById(id);
    }

    @GetMapping("/contactos")
    public List<ContactoDTO> getContacto(){
        return contactoServiceImpl.findContacto();
    }

    @GetMapping("/contacto/{id}")
    public ContactoDTO getContactoById(@PathVariable Long id){
        return contactoServiceImpl.findContactoById(id);
    }


}
