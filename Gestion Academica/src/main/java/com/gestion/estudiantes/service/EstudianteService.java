package com.gestion.estudiantes.service;

import com.gestion.estudiantes.dto.EstudianteDTO;
import com.gestion.estudiantes.entity.Estudiante;

import java.util.List;

public interface EstudianteService {
    Estudiante saveEstudiante(Estudiante e);
    Estudiante modificarEstudiante(Estudiante e, Long id);
    void deleteEstudianteById(Long id);
    List<EstudianteDTO> findEstudiantes();
    EstudianteDTO findEstudianteById(Long id);

}
