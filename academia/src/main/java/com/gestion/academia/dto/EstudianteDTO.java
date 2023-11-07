package com.gestion.academia.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@Data

public class EstudianteDTO {

    private String nombreCompleto;

    private String domicilio;

    private Integer edad;

    private String telefono;

    private String email;

    public EstudianteDTO(String nombre, String apellido, String direccion, String ciudad, String provincia,
                         LocalDate fechaNacimiento, String telefono, String email) {
        this.nombreCompleto = nombre.concat(" ").concat(apellido);
        this.domicilio = direccion.concat(" ").concat(ciudad).concat(" ").concat(provincia);
        this.edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        this.telefono = telefono;
        this.email = email;
    }

}
