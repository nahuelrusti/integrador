package com.gestion.estudiantes.controller;

import com.gestion.estudiantes.model.InstructorModel;
import com.gestion.estudiantes.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {
    @Autowired
    InstructorService instructorService;
    //Acá estaba el repository

    @PostMapping("/instructores/nuevo")
    public InstructorModel nuevoInstructor(@RequestBody InstructorModel instructorNuevo){
        return instructorService.saveInstructor(instructorNuevo);
    }

    @PutMapping("/instructores/{id}")
    public InstructorModel editarInstructor(@RequestBody InstructorModel instructor, @PathVariable Long id){
        return instructorService.modificarInstructor(instructor, id);
    }

    @DeleteMapping("/instructores/{id}")
    public void eliminarInstructor(@PathVariable Long id) {
        instructorService.deleteInstructorById(id);
    }

    @GetMapping("/instructores")
    public List<InstructorModel> getInstructor(){
        return instructorService.findInstructor();
    }

    @GetMapping("/instructores/{id}")
    public InstructorModel getInstructorById(@PathVariable Long id){
        return instructorService.findInstructorById(id);
    }
}
