package com.gestion.estudiantes.dao;

import com.gestion.estudiantes.entity.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionDAO extends JpaRepository<Calificacion, Long> {
}
