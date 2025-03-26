package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.CuidadorPaciente;
import com.xCare.model.CuidadorPacienteId;
import com.xCare.repository.CuidadorPacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
@Service
public class CuidadorPacienteServices {

    private Logger logger = Logger.getLogger(CuidadorPacienteServices.class.getName());

    @Autowired
    CuidadorPacienteRepository repository;

    public List<CuidadorPaciente> findAll() {
        logger.info("Procurando CuidadorPaciente");
        return repository.findAll();
    }

    public CuidadorPaciente create(CuidadorPaciente cuidadorPaciente) {
        logger.info("Criando CuidadorPaciente");
        return repository.save(cuidadorPaciente);
    }

    public CuidadorPaciente findById(CuidadorPacienteId id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CuidadorPaciente não encontrado"));
    }

    public CuidadorPaciente update(CuidadorPaciente cuidadorPaciente) {
        logger.info("Atualizando CuidadorPaciente");

        CuidadorPaciente entity = repository.findById(cuidadorPaciente.getId())
                .orElseThrow(() -> new ResourceNotFoundException("CuidadorPaciente não encontrado"));

        entity.setCuidador(cuidadorPaciente.getCuidador());
        entity.setPaciente(cuidadorPaciente.getPaciente());

        return repository.save(entity);
    }

    public void delete(CuidadorPacienteId id) {
        logger.info("Excluindo CuidadorPaciente");

        CuidadorPaciente entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CuidadorPaciente não encontrado"));

        repository.delete(entity);
    }
}
