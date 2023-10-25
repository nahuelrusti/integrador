package com.gestion.estudiantes.dao;

import com.gestion.estudiantes.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoDAO extends JpaRepository<Contacto, Long> {
}
