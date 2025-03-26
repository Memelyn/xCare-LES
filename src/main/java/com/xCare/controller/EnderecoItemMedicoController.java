package com.xCare.controller;

import com.xCare.Service.EnderecoItemMedicoServices;
import com.xCare.model.EnderecoItemMedico;
import com.xCare.model.EnderecoItemMedicoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EnderecoItemMedico")
public class EnderecoItemMedicoController {

    @Autowired
    private EnderecoItemMedicoServices service;

    @GetMapping(value = "/{enderecoId}/{itemMedicoId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public EnderecoItemMedico findById(@PathVariable("enderecoId") Long enderecoId,
                                       @PathVariable("itemMedicoId") Long itemMedicoId){
        EnderecoItemMedicoId id = new EnderecoItemMedicoId(enderecoId, itemMedicoId);
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnderecoItemMedico> findAll(){
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public EnderecoItemMedico create(@RequestBody EnderecoItemMedico enderecoItemMedico){
        return service.create(enderecoItemMedico);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public EnderecoItemMedico update(@RequestBody EnderecoItemMedico enderecoItemMedico){
        return service.update(enderecoItemMedico);
    }

    @DeleteMapping(value = "/{enderecoId}/{itemMedicoId}")
    public ResponseEntity<?> delete(@PathVariable("enderecoId") Long enderecoId,
                                    @PathVariable("itemMedicoId") Long itemMedicoId){
        EnderecoItemMedicoId id = new EnderecoItemMedicoId(enderecoId, itemMedicoId);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
