package com.gestion.academia.controller;

import com.gestion.academia.entity.Entidad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface Controlador<T extends Entidad, N extends Serializable> {

    ResponseEntity<? extends Object> getAll();

    ResponseEntity<? extends Object> getOne(@PathVariable N id);

    ResponseEntity<? extends Object> save(@RequestBody T entidad);

    ResponseEntity<? extends Object> update(@RequestBody T entidad);

    ResponseEntity<? extends Object> delete(@PathVariable N id);
}
