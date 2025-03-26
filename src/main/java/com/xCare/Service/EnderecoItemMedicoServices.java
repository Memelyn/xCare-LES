package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.EnderecoItemMedico;
import com.xCare.model.EnderecoItemMedicoId;
import com.xCare.repository.EnderecoItemMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.logging.Logger;

public class EnderecoItemMedicoServices {

    private Logger logger = Logger.getLogger(EnderecoItemMedicoServices.class.getName());

    @Autowired
    private EnderecoItemMedicoRepository repository;

    public List<EnderecoItemMedico> findAll(){
        logger.info("Procurando EnderecoItemMedicos");
        return repository.findAll();
    }

    public EnderecoItemMedico create(EnderecoItemMedico enderecoItemMedico){
        logger.info("Criando EnderecoItemMedico");
        return repository.save(enderecoItemMedico);
    }

    public EnderecoItemMedico findById(EnderecoItemMedicoId id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EnderecoItemMedico não encontrado"));
    }

    public EnderecoItemMedico update(EnderecoItemMedico enderecoItemMedico){
        logger.info("Atualizando EnderecoItemMedico");

        EnderecoItemMedico entity = repository.findById(enderecoItemMedico.getId())
                .orElseThrow(() -> new ResourceNotFoundException("EnderecoItemMedico não encontrado"));

        entity.setQuantidade(enderecoItemMedico.getQuantidade());

        return repository.save(entity);
    }

    public void delete(EnderecoItemMedicoId id){
        logger.info("Excluindo EnderecoItemMedico");
        EnderecoItemMedico entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EnderecoItemMedico não encontrado"));

        repository.delete(entity);
    }
}
