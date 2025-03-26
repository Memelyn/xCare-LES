package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.Paciente;
import com.xCare.repository.PacienteRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PacienteServices {
   // private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(CuidadorServices.class.getName());

    @Autowired
    PacienteRepository repository;

    public List<Paciente> findAll(){

        logger.info("Procurando Pacientes");

        return repository.findAll();

    }

    public Paciente create(Paciente paciente){
        logger.info("Criando Paciente");
        return repository.save(paciente);
    }

    public Paciente findById(Long id){

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));
    }

    public Paciente update(Paciente paciente){
        logger.info("Atualizando Paciente");

        Paciente entity = repository.findById(paciente.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

        entity.setNome(paciente.getNome());
        entity.setIdade(paciente.getIdade());
        entity.setSexo(paciente.getSexo());
        entity.setDataNascimento(paciente.getDataNascimento());
        entity.setCpf(paciente.getCpf());
        entity.setTelefone(paciente.getTelefone());
        entity.setEmail(paciente.getEmail());
        entity.setEndereco(paciente.getEndereco());
        entity.setTipoSanguineo(paciente.getTipoSanguineo());
        entity.setPlanoSaude(paciente.getPlanoSaude());


        return repository.save(paciente);
    }

    public void delete(Long id){
        logger.info("Excluindo Paciente");

        Paciente entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

        repository.delete(entity);
    }


}
