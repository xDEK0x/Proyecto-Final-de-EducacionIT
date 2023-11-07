package com.gestion.academia.service;

import com.gestion.academia.dto.EstudianteDTO;
import com.gestion.academia.entity.Estudiante;
import com.gestion.academia.exception.EstudianteNoEncontradoException;

public interface EstudianteServicio extends Servicio<Estudiante, Integer> {

    EstudianteDTO findByIdDTO(Integer id) throws EstudianteNoEncontradoException;

}
