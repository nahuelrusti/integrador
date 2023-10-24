package com.gestion.estudiantes.services;

import com.gestion.estudiantes.repository.ContactoRepository;
import com.gestion.estudiantes.model.ContactoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoService {

    @Autowired
    ContactoRepository contactoRepository;

    //Post, .saveContacto
    public ContactoModel saveContacto(ContactoModel contactoModel){
        return contactoRepository.save(contactoModel);
    }

    //Put, .modificarContacto
    public ContactoModel modificarContacto(ContactoModel contacto, Long id){
        Optional<ContactoModel> contactoModificable = contactoRepository.findById(id);
        if(contactoModificable.isPresent()){
            ContactoModel contactoViejo = contactoModificable.get();
            contactoViejo.setEmail(contacto.getEmail());
            contactoViejo.setTelefono(contacto.getTelefono());
            contactoViejo.setCiudad(contacto.getCiudad());
            contactoViejo.setProvincia(contacto.getProvincia());
            contactoViejo.setCodigoPostal(contacto.getCodigoPostal());
            return contactoRepository.save(contactoViejo);
        }else{
            return null;
        }
    }

    //DeleteById, .deleteContactoById
    public void deleteContactoById(Long id){
        contactoRepository.deleteById(id);
    }

    //Get, .findCursos
    public List<ContactoModel> findContacto() {return contactoRepository.findAll();}

    //GetById, .findContactoById
    public ContactoModel findContactoById(Long id){
        return contactoRepository.findById(id).orElse(null);
    }


}
