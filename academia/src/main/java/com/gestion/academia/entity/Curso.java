package com.gestion.academia.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "cursos")
public class Curso extends Entidad {

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_instructor")
    private Instructor instructor;

}
