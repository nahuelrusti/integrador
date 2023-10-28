package com.gestion.estudiantes.service;

import com.gestion.estudiantes.dto.CursoDTO;
import com.gestion.estudiantes.entity.Curso;

import java.util.List;

public interface CursoService {
    Curso saveCurso(Curso c);
    Curso modificarCurso(Curso c, Long id);
    void deleteCursoById(Long id);
    List<CursoDTO> findCursos();
    CursoDTO findCursoById(Long id);
}
