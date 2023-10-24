package com.gestion.estudiantes.services;

import com.gestion.estudiantes.model.InstructorModel;
import com.gestion.estudiantes.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    InstructorRepository instructorRepository;

    //Post, .saveInstructor
    public InstructorModel saveInstructor(InstructorModel instructor){
        return instructorRepository.save(instructor);
    }

    //Put, .modificarInstructor
    public InstructorModel modificarInstructor(InstructorModel instructor, Long id){
        Optional<InstructorModel> instructorModificable = instructorRepository.findById(id);
        if(instructorModificable.isPresent()){
            InstructorModel instructorViejo = instructorModificable.get();
            instructorViejo.setNombre(instructor.getNombre());
            instructorViejo.setApellido(instructor.getApellido());
            return instructorRepository.save(instructorViejo);
        }else{
            return null;
        }
    }

    //DeleteById, .deleteInstructorById
    public void deleteInstructorById(Long id){instructorRepository.deleteById(id);
    }

    //Get, .findInstructor
    public List<InstructorModel> findInstructor() {return instructorRepository.findAll();}

    //GetById, .findInstructorById
    public InstructorModel findInstructorById(Long id) {return instructorRepository.findById(id).orElse(null);
    }



}
