package com.gestion.estudiantes.controller;

import com.gestion.estudiantes.services.CursoService;
import com.gestion.estudiantes.model.CursoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CursoController {
    @Autowired
    CursoService cursoService;
    //Acá estaba el repository

    @PostMapping("/cursos/nuevo")
    public CursoModel nuevoCurso(@RequestBody CursoModel cursoNuevo){
        return cursoService.saveCurso(cursoNuevo);
    }

    @PutMapping("/cursos/{id}")
    public CursoModel editarCurso(@RequestBody CursoModel curso, @PathVariable Long id){
        return cursoService.modificarCurso(curso, id);
    }

    @DeleteMapping("/cursos/{id}")
    public void eliminarCurso(@PathVariable Long id) {
        cursoService.deleteCursoById(id);
    }

    @GetMapping("/cursos")
    public List<CursoModel> getCurso(){
        return cursoService.findCursos();
    }

    @GetMapping("/cursos/{id}")
    public CursoModel getCursoById(@PathVariable Long id){
        return cursoService.findCursoById(id);
    }


}
