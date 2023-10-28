package com.gestion.estudiantes.servicesImpl;

import com.gestion.estudiantes.dao.ContactoDAO;
import com.gestion.estudiantes.dto.ContactoDTO;
import com.gestion.estudiantes.entity.Contacto;
import com.gestion.estudiantes.entity.Estudiante;
import com.gestion.estudiantes.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Override
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
    @Override
    public void deleteContactoById(Long id){
        contactoDAO.deleteById(id);
    }

    //Get, .findCursos
    @Override
    public List<ContactoDTO> findContacto() {
        return crearListDTO(contactoDAO.findAll());
    }
        //return contactoDAO.findAll();}

    //GetById, .findContactoById
    @Override
    public ContactoDTO findContactoById(Long id){
        Contacto c = contactoDAO.findById(id).orElse(null);
        if(c != null) {
            return crearDTO(c);
        }
        return null;
    }

    //Methods

    private List<ContactoDTO> crearListDTO(List<Contacto> contactos){
        List<ContactoDTO> contactoDTO = new ArrayList<>();
        for (Contacto e:contactos) {
            contactoDTO.add(crearDTO(e));
        }
        return contactoDTO;
    }

    private ContactoDTO crearDTO(Contacto c){
        return new ContactoDTO(c.getEmail(), c.getTelefono(), c);
    }

}
