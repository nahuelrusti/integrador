package com.gestion.estudiantes.controller;

import com.gestion.estudiantes.dto.CursoDTO;
import com.gestion.estudiantes.servicesImpl.CursoServiceImpl;
import com.gestion.estudiantes.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CursoController {
    @Autowired
    private CursoServiceImpl cursoServiceImpl;
    //Acá estaba el repository

    @PostMapping("/cursos/nuevo")
    public Curso nuevoCurso(@RequestBody Curso cursoNuevo){
        return cursoServiceImpl.saveCurso(cursoNuevo);
    }

    @PutMapping("/cursos/{id}")
    public Curso editarCurso(@RequestBody Curso curso, @PathVariable Long id){
        return cursoServiceImpl.modificarCurso(curso, id);
    }

    @DeleteMapping("/cursos/{id}")
    public void eliminarCurso(@PathVariable Long id) {
        cursoServiceImpl.deleteCursoById(id);
    }

    @GetMapping("/cursos")
    public List<CursoDTO> getCurso(){
        return cursoServiceImpl.findCursos();
    }

    @GetMapping("/cursos/{id}")
    public CursoDTO getCursoById(@PathVariable Long id){
        return cursoServiceImpl.findCursoById(id);
    }


}
