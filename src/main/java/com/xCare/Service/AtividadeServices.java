package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.Atividade;
import com.xCare.repository.AtividadeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class AtividadeServices {
   // private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(AtividadeServices.class.getName());

    @Autowired
    AtividadeRepository repository;

    public List<Atividade> findAll(){

        logger.info("Achando Atividadees");

        return repository.findAll();

    }

    public Atividade create(Atividade atividade){
        logger.info("criando Atividade");
        return repository.save(atividade);
    }

    public Atividade findById(Long id){

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public Atividade update(Atividade atividade){
        logger.info("updating Atividade");

        Atividade entity = repository.findById(atividade.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setCuidador(atividade.getCuidador());
        entity.setPaciente(atividade.getPaciente());
        entity.setDataHora(atividade.getDataHora());
        entity.setDescricao(atividade.getDescricao());

        return repository.save(atividade);
    }

    public void delete(Long id){
        logger.info("Deleting one person");

        Atividade entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }


}
