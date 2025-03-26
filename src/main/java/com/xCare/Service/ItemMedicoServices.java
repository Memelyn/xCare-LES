package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.ItemMedico;
import com.xCare.repository.ItemMedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class ItemMedicoServices {
   // private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(ItemMedicoServices.class.getName());

    @Autowired
    ItemMedicoRepository repository;

    public List<ItemMedico> findAll(){

        logger.info("Procurando ItemMedicos");

        return repository.findAll();

    }

    public ItemMedico create(ItemMedico itemMedico){
        logger.info("Criando ItemMedico");
        return repository.save(itemMedico);
    }

    public ItemMedico findById(Long id){

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemMedico não encontrado"));
    }

    public ItemMedico update(ItemMedico itemMedico){
        logger.info("Atualizando ItemMedico");

        ItemMedico entity = repository.findById(itemMedico.getRegistroAnvisa())
                .orElseThrow(() -> new ResourceNotFoundException("ItemMedico não encontrado"));

        entity.setNome(itemMedico.getNome());
        entity.setDescricao(itemMedico.getDescricao());
        entity.setTipoUnidade(itemMedico.getTipoUnidade());
        

        return repository.save(itemMedico);
    }

    public void delete(Long id){
        logger.info("Excluindo ItemMedico");

        ItemMedico entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemMedico não encontrado"));

        repository.delete(entity);
    }


}
