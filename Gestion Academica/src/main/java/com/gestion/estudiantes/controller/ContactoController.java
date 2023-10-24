package com.gestion.estudiantes.controller;

import com.gestion.estudiantes.model.ContactoModel;
import com.gestion.estudiantes.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContactoController {
    @Autowired
    ContactoService contactoService;
    //Acá estaba el repository

    @PostMapping("/contactos/nuevo")
    public ContactoModel nuevoContacto(@RequestBody ContactoModel contactoNuevo){
        return contactoService.saveContacto(contactoNuevo);
    }

    @PutMapping("/contactos/{id}")
    public ContactoModel editarContacto(@RequestBody ContactoModel contacto, @PathVariable Long id){
        return contactoService.modificarContacto(contacto, id);
    }

    @DeleteMapping("/contactos/{id}")
    public void eliminarContacto(@PathVariable Long id) {
        contactoService.deleteContactoById(id);
    }

    @GetMapping("/contactos")
    public List<ContactoModel> getContacto(){
        return contactoService.findContacto();
    }

    @GetMapping("/contacto/{id}")
    public ContactoModel getContactoById(@PathVariable Long id){
        return contactoService.findContactoById(id);
    }


}
