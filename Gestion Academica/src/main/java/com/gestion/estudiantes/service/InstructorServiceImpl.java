package com.gestion.estudiantes.service;

import com.gestion.estudiantes.entity.Instructor;
import com.gestion.estudiantes.dao.InstructorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    InstructorDAO instructorDAO;

    //Post, .saveInstructor
    public Instructor saveInstructor(Instructor instructor){
        return instructorDAO.save(instructor);
    }

    //Put, .modificarInstructor
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
    public void deleteInstructorById(Long id){
        instructorDAO.deleteById(id);
    }

    //Get, .findInstructor
    public List<Instructor> findInstructor() {return instructorDAO.findAll();}

    //GetById, .findInstructorById
    public Instructor findInstructorById(Long id) {return instructorDAO.findById(id).orElse(null);
    }



}
