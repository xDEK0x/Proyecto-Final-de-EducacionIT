package com.gestion.academia.service;

import com.gestion.academia.entity.Entidad;

import java.io.Serializable;
import java.util.List;

public interface Servicio<T extends Entidad, N extends Serializable> {

    List<T> findAll() throws Exception;

    T findById(N id) throws Exception;

    T save(T entidad) throws Exception;

    T update(T entidad) throws Exception;

    Boolean delete(N id) throws Exception;

}
