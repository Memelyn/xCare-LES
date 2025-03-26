package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.EnderecoMedicamento;
import com.xCare.model.EnderecoMedicamentoId;
import com.xCare.repository.EnderecoMedicamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

public class EnderecoMedicamentoServices {

    private Logger logger = Logger.getLogger(EnderecoMedicamentoServices.class.getName());

    @Autowired
    EnderecoMedicamentoRepository repository;

    public List<EnderecoMedicamento> findAll() {
        logger.info("Procurando EnderecoMedicamento");
        return repository.findAll();
    }

    public EnderecoMedicamento create(EnderecoMedicamento enderecoMedicamento) {
        logger.info("Criando EnderecoMedicamento");
        return repository.save(enderecoMedicamento);
    }

    public EnderecoMedicamento findById(EnderecoMedicamentoId id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EnderecoMedicamento não encontrado"));
    }

    public EnderecoMedicamento update(EnderecoMedicamento enderecoMedicamento) {
        logger.info("Atualizando EnderecoMedicamento");

        EnderecoMedicamento entity = repository.findById(enderecoMedicamento.getId())
                .orElseThrow(() -> new ResourceNotFoundException("EnderecoMedicamento não encontrado"));

        entity.setMedicamento(enderecoMedicamento.getMedicamento());
        entity.setEndereco(enderecoMedicamento.getEndereco());
        entity.setQuantidade(enderecoMedicamento.getQuantidade());

        return repository.save(entity);
    }

    public void delete(EnderecoMedicamentoId id) {
        logger.info("Excluindo EnderecoMedicamento");

        EnderecoMedicamento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EnderecoMedicamento não encontrado"));

        repository.delete(entity);
    }
}
