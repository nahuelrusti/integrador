package com.gestion.estudiantes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor

@Data

@Entity(name = "Contactos")
@Table
public class ContactoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    private EstudianteModel estudianteFk;
}
