package com.gestion.academia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "instructores")
public class Instructor extends Entidad {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

}
