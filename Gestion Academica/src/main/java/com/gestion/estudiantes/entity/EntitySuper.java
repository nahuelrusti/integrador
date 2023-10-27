package com.gestion.estudiantes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@MappedSuperclass
public class EntitySuper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Autoincremento por identidad
    private Long id;

}
