package com.gestion.estudiantes.controller;

import com.gestion.estudiantes.dto.InstructorDTO;
import com.gestion.estudiantes.entity.Instructor;
import com.gestion.estudiantes.servicesImpl.InstructorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {
    @Autowired
    private InstructorServiceImpl instructorServiceImpl;
    //Acá estaba el repository

    @PostMapping("/instructores/nuevo")
    public Instructor nuevoInstructor(@RequestBody Instructor instructorNuevo){
        return instructorServiceImpl.saveInstructor(instructorNuevo);
    }

    @PutMapping("/instructores/{id}")
    public Instructor editarInstructor(@RequestBody Instructor instructor, @PathVariable Long id){
        return instructorServiceImpl.modificarInstructor(instructor, id);
    }

    @DeleteMapping("/instructores/{id}")
    public void eliminarInstructor(@PathVariable Long id) {
        instructorServiceImpl.deleteInstructorById(id);
    }

    @GetMapping("/instructores")
    public List<InstructorDTO> getInstructor(){
        return instructorServiceImpl.findInstructor();
    }

    @GetMapping("/instructores/{id}")
    public InstructorDTO getInstructorById(@PathVariable Long id){
        return instructorServiceImpl.findInstructorById(id);
    }
}
