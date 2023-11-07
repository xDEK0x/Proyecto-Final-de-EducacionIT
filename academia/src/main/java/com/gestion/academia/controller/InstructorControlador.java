package com.gestion.academia.controller;

import com.gestion.academia.entity.Instructor;
import com.gestion.academia.service.InstructorServicioImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/instructores")
public class InstructorControlador extends ControladorImpl<Instructor, InstructorServicioImpl> {

    public InstructorControlador(InstructorServicioImpl servicio) {
        super(servicio);
    }
}
