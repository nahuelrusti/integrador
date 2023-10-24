package com.gestion.estudiantes.controller;

import com.gestion.estudiantes.model.EstudianteModel;
import com.gestion.estudiantes.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;
    //Acá estaba el repository

    @PostMapping("/estudiante/nuevo")
    public EstudianteModel nuevoEstudiante(@RequestBody EstudianteModel estudianteModel){
        return estudianteService.saveEstudiante(estudianteModel);
    }

    @PutMapping("/estudiante/{id}")
    public EstudianteModel editarEstudiante(@RequestBody EstudianteModel estudiante, @PathVariable Long id){
        return estudianteService.modificarEstudiante(estudiante, id);
    }

    @DeleteMapping("/estudiante/{id}")
    public void eliminarEstudiante(@PathVariable Long id){
        estudianteService.deleteEstudianteById(id);
    }

    @GetMapping("/estudiante")
    public  List<EstudianteModel> getEstudiante(){
        return  estudianteService.findEstudiantes();
    }

    @GetMapping("/estudiante/{id}")
    public EstudianteModel getEstudianteById(@PathVariable Long Id){
        return estudianteService.findEstudianteById(Id);
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

