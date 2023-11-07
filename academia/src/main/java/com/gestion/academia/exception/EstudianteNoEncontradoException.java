package com.gestion.academia.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EstudianteNoEncontradoException extends Exception{

    /* Por convención, su nombre debería terminar con la palabra Exception
    Consiste en crear una clase que hereda de java.lang.Exception */

    private String descripcion;

    @Override
    public String getMessage() {
        return "Estudiante NO Encontrado ".concat("{").concat(this.descripcion).concat("}");
    }
}
