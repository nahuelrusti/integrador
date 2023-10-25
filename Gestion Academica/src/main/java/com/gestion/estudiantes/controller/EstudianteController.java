package com.gestion.estudiantes.controller;

import com.gestion.estudiantes.entity.Estudiante;
import com.gestion.estudiantes.services.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EstudianteController {
    @Autowired
    private EstudianteServiceImpl estudianteServiceImpl;
    //Acá estaba el repository

    @PostMapping("/estudiante/nuevo")
    public Estudiante nuevoEstudiante(@RequestBody Estudiante estudiante){
        return estudianteServiceImpl.saveEstudiante(estudiante);
    }

    @PutMapping("/estudiante/{id}")
    public Estudiante editarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Long id){
        return estudianteServiceImpl.modificarEstudiante(estudiante, id);
    }

    @DeleteMapping("/estudiante/{id}")
    public void eliminarEstudiante(@PathVariable Long id){
        estudianteServiceImpl.deleteEstudianteById(id);
    }

    @GetMapping("/estudiante")
    public  List<Estudiante> getEstudiante(){
        return  estudianteServiceImpl.findEstudiantes();
    }

    @GetMapping("/estudiante/{id}")
    public Estudiante getEstudianteById(@PathVariable Long id){
        return estudianteServiceImpl.findEstudianteById(id);
    }


    //Put no funcional, dejado como ejemplo y reemplazado por "editarEstudiante"

    /*@PutMapping("/estudiante/editar/{id}")
    public EstudianteModel putEstudiante(@PathVariable Long id, @RequestBody EstudianteModel estudianteModel){
        Optional<EstudianteModel> estudianteExistente = estudianteService.findEstudianteById(id);
        if (estudianteExistente.isPresent()){
            EstudianteModel estudianteModelActual = estudianteExistente.get();
            estudianteModelActual.setNombre(estudianteModel.getNombre());
            estudianteModelActual.setApellido(estudianteModel.getApellido());
            estudianteModelActual.setDni(estudianteModel.getDni());
            estudianteModelActual.setCurso(estudianteModel.getCurso());
            return estudianteService.saveEstudiante(estudianteModelActual);
        }else{
        return null;}*/
}

