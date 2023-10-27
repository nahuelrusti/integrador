package com.gestion.estudiantes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor

@Data

@Entity(name = "Contactos")
@Table
public class Contacto extends EntitySuper {

    @Column
    private String email;

    @Column
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String provincia;

    @Column(nullable = false)
    private String codigoPostal;

    @OneToOne(optional = false)
    //Optional False: obligatorio
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id")
    private Estudiante estudianteFk;

    @CreationTimestamp
    private LocalDateTime creacion;

    @UpdateTimestamp
    private LocalDateTime modificacion;

}
