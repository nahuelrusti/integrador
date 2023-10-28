package com.gestion.estudiantes.service;

import com.gestion.estudiantes.dto.CalificacionDTO;
import com.gestion.estudiantes.entity.Calificacion;

import java.util.List;

public interface CalificacionService {
    Calificacion saveCalificacion(Calificacion c);

    Calificacion modificarCalificacion(Calificacion c, Long id);

    void deleteCalificacionById(Long id);

    List<CalificacionDTO> findCalificacion();

    CalificacionDTO findCalificacionById(Long id);
}
