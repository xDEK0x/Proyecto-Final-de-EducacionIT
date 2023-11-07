package com.gestion.academia.controller;

import com.gestion.academia.entity.Entidad;
import com.gestion.academia.service.ServicioImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class ControladorImpl<T extends Entidad, S extends ServicioImpl<T, Integer>> implements Controlador<T, Integer> {

    protected S servicio;

    protected final String ERROR = "Se produjo un Error! ";

    public ControladorImpl(S servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(this.ERROR);
        }
    }

    @Operation(summary = "Obtener una Entidad por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontré la Entidad",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Entidad.class)) }),
            @ApiResponse(responseCode = "400", description = "Id no válida",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entidad no encontrada",
                    content = @Content) })
    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(this.ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody T entidad) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entidad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.ERROR);
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> update(@RequestBody T entidad) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(entidad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.ERROR);
        }
    }

}
