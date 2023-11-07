package com.gestion.academia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "estudiantes")
public class Estudiante extends Entidad {

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_contacto")
    private Contacto contacto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "id_estudiante"),
            inverseJoinColumns = @JoinColumn(name = "id_curso"))
    private List<Curso> cursos = new ArrayList<>();

}
