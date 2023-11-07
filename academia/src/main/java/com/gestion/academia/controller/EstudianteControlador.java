package com.gestion.academia.controller;

import com.gestion.academia.entity.Entidad;
import com.gestion.academia.entity.Estudiante;
import com.gestion.academia.exception.EstudianteNoEncontradoException;
import com.gestion.academia.service.EstudianteServicioImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/estudiantes")
public class EstudianteControlador extends ControladorImpl<Estudiante, EstudianteServicioImpl> {

    public EstudianteControlador(EstudianteServicioImpl servicio) {
        super(servicio);
    }

    @Operation(summary = "Obtener un Estudiante por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontré el Estudiante",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Entidad.class)) }),
            @ApiResponse(responseCode = "400", description = "Id no válida",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado",
                    content = @Content) })
    @GetMapping("/dto/{id}")
    public ResponseEntity<?> getOneDTO(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByIdDTO(id));
        } catch (EstudianteNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(super.ERROR.concat(e.getMessage()));
        }
    }

}
