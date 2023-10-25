package com.gestion.estudiantes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestion.estudiantes.entity.Estudiante;


@Repository
public interface EstudianteDAO extends JpaRepository<Estudiante, Long> {
}
