package com.gestion.estudiantes.repository;

import com.gestion.estudiantes.model.ContactoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<ContactoModel, Long> {
}
