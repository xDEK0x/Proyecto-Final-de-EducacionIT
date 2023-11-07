package com.gestion.academia.service;

import com.gestion.academia.dto.EstudianteDTO;
import com.gestion.academia.entity.Contacto;
import com.gestion.academia.entity.Estudiante;
import com.gestion.academia.exception.EstudianteNoEncontradoException;
import com.gestion.academia.repository.EstudianteRepositorio;
import com.gestion.academia.repository.Repositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteServicioImpl extends ServicioImpl<Estudiante, Integer> implements EstudianteServicio {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    public EstudianteServicioImpl(Repositorio<Estudiante, Integer> repositorio) {
        super(repositorio);
    }

    @Override
    @Transactional
    public EstudianteDTO findByIdDTO(Integer id) throws EstudianteNoEncontradoException {
        try {
            Optional<Estudiante> optional = repositorio.findById(id);
            Estudiante e = optional.get();
            Contacto c = e.getContacto();
            return new EstudianteDTO(e.getNombre(), e.getApellido(), c.getDireccion(), c.getCiudad(), c.getProvincia(),
                    e.getFechaNacimiento(), c.getTelefono(), c.getEmail());
        } catch (Exception e) {
            throw new EstudianteNoEncontradoException(e.getMessage());
        }

    }

}
