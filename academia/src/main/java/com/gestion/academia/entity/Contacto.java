package com.gestion.academia.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "contactos")
public class Contacto extends Entidad {

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "codigo_postal")
    private String codigoPostal;

}
