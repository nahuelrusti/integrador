package com.gestion.estudiantes.services;

import com.gestion.estudiantes.entity.Estudiante;

import java.util.List;

public interface EstudianteService {
    Estudiante saveEstudiante(Estudiante e);
    Estudiante modificarEstudiante(Estudiante e, Long id);
    void deleteEstudianteById(Long id);
    List<Estudiante> findEstudiantes();
    Estudiante findEstudianteById(Long id);

}
