package com.xCare.controller;

import com.xCare.Service.CuidadorPacienteServices;
import com.xCare.model.CuidadorPaciente;
import com.xCare.model.CuidadorPacienteId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CuidadorPaciente")
public class CuidadorPacienteController {

    @Autowired
    private CuidadorPacienteServices service;

    @GetMapping(value = "/{cuidadorId}/{pacienteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CuidadorPaciente findById(@PathVariable("cuidadorId") Long cuidadorId,
                                      @PathVariable("pacienteId") Long pacienteId) {
        CuidadorPacienteId id = new CuidadorPacienteId(cuidadorId, pacienteId);
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CuidadorPaciente> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CuidadorPaciente create(@RequestBody CuidadorPaciente cuidadorPaciente) {
        return service.create(cuidadorPaciente);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CuidadorPaciente update(@RequestBody CuidadorPaciente cuidadorPaciente) {
        return service.update(cuidadorPaciente);
    }

    @DeleteMapping(value = "/{cuidadorId}/{pacienteId}")
    public ResponseEntity<?> delete(@PathVariable("cuidadorId") Long cuidadorId,
                                    @PathVariable("pacienteId") Long pacienteId) {
        CuidadorPacienteId id = new CuidadorPacienteId(cuidadorId, pacienteId);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
