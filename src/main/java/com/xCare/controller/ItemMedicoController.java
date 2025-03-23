package com.xCare.controller;

import com.xCare.Service.ItemMedicoServices;
import com.xCare.model.ItemMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ItemMedico")
public class ItemMedicoController {

    @Autowired

    private ItemMedicoServices service;

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemMedico findById(@PathVariable("id") Long id){
        return  service.findById(id);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemMedico> findAll(){
        return  service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ItemMedico create (@RequestBody ItemMedico itemMedico){
        return service.create(itemMedico);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ItemMedico update (@RequestBody ItemMedico itemMedico){
        return service.update(itemMedico);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
