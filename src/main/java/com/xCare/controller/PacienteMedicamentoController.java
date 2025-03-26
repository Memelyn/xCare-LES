package com.xCare.controller;

import com.xCare.model.PacienteMedicamento;
import com.xCare.model.PacienteMedicamentoId;
import com.xCare.Service.PacienteMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Paciente/Medicamento")
public class PacienteMedicamentoController {

    @Autowired
    private PacienteMedicamentoService service;

    @GetMapping(value = "/{medicamentoId}/{pacienteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PacienteMedicamento findById(@PathVariable("medicamentoId") Long medicamentoId,
                                        @PathVariable("pacienteId") Long pacienteId) {
        PacienteMedicamentoId id = new PacienteMedicamentoId(medicamentoId, pacienteId);
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PacienteMedicamento> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PacienteMedicamento create(@RequestBody PacienteMedicamento pacienteMedicamento) {
        return service.create(pacienteMedicamento);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PacienteMedicamento update(@RequestBody PacienteMedicamento pacienteMedicamento) {
        return service.update(pacienteMedicamento);
    }

    @DeleteMapping(value = "/{medicamentoId}/{pacienteId}")
    public ResponseEntity<?> delete(@PathVariable("medicamentoId") Long medicamentoId,
                                    @PathVariable("pacienteId") Long pacienteId) {
        PacienteMedicamentoId id = new PacienteMedicamentoId(medicamentoId, pacienteId);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
