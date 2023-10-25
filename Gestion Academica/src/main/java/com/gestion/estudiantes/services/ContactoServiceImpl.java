package com.gestion.estudiantes.services;

import com.gestion.estudiantes.dao.ContactoDAO;
import com.gestion.estudiantes.entity.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoServiceImpl implements ContactoService{

    @Autowired
    ContactoDAO contactoDAO;

    //Post, .saveContacto
    public Contacto saveContacto(Contacto contacto){
        return contactoDAO.save(contacto);
    }

    //Put, .modificarContacto
    public Contacto modificarContacto(Contacto contacto, Long id){
        Optional<Contacto> contactoModificable = contactoDAO.findById(id);
        if(contactoModificable.isPresent()){
            Contacto contactoViejo = contactoModificable.get();
            contactoViejo.setEmail(contacto.getEmail());
            contactoViejo.setTelefono(contacto.getTelefono());
            contactoViejo.setCiudad(contacto.getCiudad());
            contactoViejo.setProvincia(contacto.getProvincia());
            contactoViejo.setCodigoPostal(contacto.getCodigoPostal());
            return contactoDAO.save(contactoViejo);
        }else{
            return null;
        }
    }

    //DeleteById, .deleteContactoById
    public void deleteContactoById(Long id){
        contactoDAO.deleteById(id);
    }

    //Get, .findCursos
    public List<Contacto> findContacto() {return contactoDAO.findAll();}

    //GetById, .findContactoById
    public Contacto findContactoById(Long id){
        return contactoDAO.findById(id).orElse(null);
    }


}
