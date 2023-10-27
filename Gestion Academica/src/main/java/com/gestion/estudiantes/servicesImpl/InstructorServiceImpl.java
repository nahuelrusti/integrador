package com.gestion.estudiantes.servicesImpl;

import com.gestion.estudiantes.dto.InstructorDTO;
import com.gestion.estudiantes.entity.Instructor;
import com.gestion.estudiantes.dao.InstructorDAO;
import com.gestion.estudiantes.services.InstructorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    InstructorDAO instructorDAO;

    //Post, .saveInstructor
    @Override
    public Instructor saveInstructor(Instructor instructor){
        return instructorDAO.save(instructor);
    }

    //Put, .modificarInstructor
    @Override
    public Instructor modificarInstructor(Instructor instructor, Long id){
        Optional<Instructor> instructorModificable = instructorDAO.findById(id);
        if(instructorModificable.isPresent()){
            Instructor instructorViejo = instructorModificable.get();
            instructorViejo.setNombre(instructor.getNombre());
            instructorViejo.setApellido(instructor.getApellido());
            return instructorDAO.save(instructorViejo);
        }else{
            return null;
        }
    }

    //DeleteById, .deleteInstructorById
    @Override
    public void deleteInstructorById(Long id){
        instructorDAO.deleteById(id);
    }

    //Get, .findInstructor
    @Override
    public List<InstructorDTO> findInstructor() {
        return crearListDTO(instructorDAO.findAll());}

    //GetById, .findInstructorById
    @Override
    public InstructorDTO findInstructorById(Long id) {
        Instructor instructor =  instructorDAO.findById(id).orElse(null);

        ModelMapper model = new ModelMapper();
        return model.map(instructor, InstructorDTO.class);
        //Construir un DTO a partir de una variable de referencia origen (instructor)
    }

    private List<InstructorDTO> crearListDTO(List<Instructor> instructores){
        List<InstructorDTO> instrutorDTO = new ArrayList<>();
        for (Instructor e:instructores) {
            instrutorDTO.add(crearDTO(e));
        }
        return instrutorDTO;
    }

    private InstructorDTO crearDTO(Instructor c){
        return new InstructorDTO(c.getNombre(), c.getApellido());
    }
}
