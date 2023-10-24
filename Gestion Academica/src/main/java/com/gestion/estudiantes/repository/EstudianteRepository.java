package com.gestion.estudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestion.estudiantes.model.EstudianteModel;


@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteModel, Long> {
}
