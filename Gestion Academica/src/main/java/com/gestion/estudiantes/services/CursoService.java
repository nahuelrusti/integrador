package com.gestion.estudiantes.services;

import com.gestion.estudiantes.entity.Curso;

import java.util.List;

public interface CursoService {
    Curso saveCurso(Curso c);
    Curso modificarCurso(Curso c, Long id);
    void deleteCursoById(Long id);
    List<Curso> findCursos();
    Curso findCursoById(Long id);
}
