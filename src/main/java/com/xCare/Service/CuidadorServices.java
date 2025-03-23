package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.Cuidador;
import com.xCare.repository.CuidadorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class CuidadorServices {
   // private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(CuidadorServices.class.getName());

    @Autowired
    CuidadorRepository repository;

    public List<Cuidador> findAll(){

        logger.info("Achando cuidadores");

        return repository.findAll();

    }

    public Cuidador create(Cuidador cuidador){
        logger.info("criando cuidador");
        return repository.save(cuidador);
    }

    public Cuidador findById(Long id){

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public Cuidador update(Cuidador cuidador){
        logger.info("updating cuidador");

        Cuidador entity = repository.findById(cuidador.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setNome(cuidador.getNome());
        entity.setIdade(cuidador.getIdade());
        entity.setSexo(cuidador.getSexo());
        entity.setDataNascimento(cuidador.getDataNascimento());
        entity.setCpf(cuidador.getCpf());
        entity.setTelefone(cuidador.getTelefone());
        entity.setEmail(cuidador.getEmail());
        entity.setEmpresa(cuidador.getEmpresa());
        entity.setCargaHoraria(cuidador.getCargaHoraria());
        entity.setEspecializacao(cuidador.getEspecializacao());


        return repository.save(cuidador);
    }

    public void delete(Long id){
        logger.info("Deleting one person");

        Cuidador entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }


}
