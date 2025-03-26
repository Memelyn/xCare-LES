package com.xCare.controller;

import com.xCare.Service.EnderecoMedicamentoServices;
import com.xCare.model.EnderecoMedicamento;
import com.xCare.model.EnderecoMedicamentoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EnderecoMedicamento")
public class EnderecoMedicamentoController {

    @Autowired
    private EnderecoMedicamentoServices service;

    @GetMapping(value = "/{registroAnvisaMedicamento}/{idEndereco}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EnderecoMedicamento findById(@PathVariable("registroAnvisaMedicamento") Long registroAnvisaMedicamento,
                                        @PathVariable("idEndereco") Long idEndereco) {
        EnderecoMedicamentoId id = new EnderecoMedicamentoId(registroAnvisaMedicamento, idEndereco);
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnderecoMedicamento> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EnderecoMedicamento create(@RequestBody EnderecoMedicamento enderecoMedicamento) {
        return service.create(enderecoMedicamento);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EnderecoMedicamento update(@RequestBody EnderecoMedicamento enderecoMedicamento) {
        return service.update(enderecoMedicamento);
    }

    @DeleteMapping(value = "/{registroAnvisaMedicamento}/{idEndereco}")
    public ResponseEntity<?> delete(@PathVariable("registroAnvisaMedicamento") Long registroAnvisaMedicamento,
                                    @PathVariable("idEndereco") Long idEndereco) {
        EnderecoMedicamentoId id = new EnderecoMedicamentoId(registroAnvisaMedicamento, idEndereco);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
