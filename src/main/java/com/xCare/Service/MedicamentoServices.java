package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.Medicamento;
import com.xCare.repository.MedicamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class MedicamentoServices {
   // private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(CuidadorServices.class.getName());

    @Autowired
    MedicamentoRepository repository;

    public List<Medicamento> findAll(){

        logger.info("Procurando Medicamentos");

        return repository.findAll();

    }

    public Medicamento create(Medicamento medicamento){
        logger.info("Criando Medicamento");
        return repository.save(medicamento);
    }

    public Medicamento findById(Long id){

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento não encontrado"));
    }

    public Medicamento update(Medicamento medicamento){
        logger.info("Atualizando Medicamento");

        Medicamento entity = repository.findById(medicamento.getRegistroAnvisa())
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento não encontrado"));

        entity.setNome(medicamento.getNome());
        entity.setDescricao(medicamento.getDescricao());
    

        return repository.save(medicamento);
    }

    public void delete(Long id){
        logger.info("Excluindo Medicamento");

        Medicamento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento não encontrado"));

        repository.delete(entity);
    }


}
