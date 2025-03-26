package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.Relatorio;
import com.xCare.repository.RelatorioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class RelatorioServices {
   // private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(CuidadorServices.class.getName());

    @Autowired
    RelatorioRepository repository;

    public List<Relatorio> findAll(){

        logger.info("Procurando Relatórios");

        return repository.findAll();

    }

    public Relatorio create(Relatorio relatorio){
        logger.info("Criando Relatorio");
        return repository.save(relatorio);
    }

    public Relatorio findById(Long id){

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relatorio não encontrado"));
    }

    public Relatorio update(Relatorio relatorio){
        logger.info("Atualizando Relatorio");

        Relatorio entity = repository.findById(relatorio.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Relatorio não encontrado"));

        entity.setCuidador(relatorio.getCuidador());
        entity.setPaciente(relatorio.getPaciente());
        entity.setDataInicio(relatorio.getDataInicio());
        entity.setDataFim(relatorio.getDataFim());
        entity.setObservacoes(relatorio.getObservacoes());

        return repository.save(relatorio);
    }

    public void delete(Long id){
        logger.info("Excluindo Relatorio");

        Relatorio entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relatorio não encontrado"));

        repository.delete(entity);
    }


}
