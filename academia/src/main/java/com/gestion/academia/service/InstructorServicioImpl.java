package com.gestion.academia.service;

import com.gestion.academia.entity.Instructor;
import com.gestion.academia.repository.InstructorRepositorio;
import com.gestion.academia.repository.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServicioImpl extends ServicioImpl<Instructor, Integer> implements InstructorServicio {

    @Autowired
    private InstructorRepositorio instructorRepositorio;

    public InstructorServicioImpl(Repositorio<Instructor, Integer> repositorio) {
        super(repositorio);
    }

}
