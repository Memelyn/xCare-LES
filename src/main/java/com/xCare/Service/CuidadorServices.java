package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.Cuidador;
import com.xCare.repository.CuidadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class CuidadorServices {
   // private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(CuidadorServices.class.getName());

    @Autowired
    CuidadorRepository repository;

    public List<Cuidador> findAll(){

        logger.info("Procurando Cuidadores");

        return repository.findAll();

    }

    public Cuidador create(Cuidador cuidador){
        logger.info("Criando Cuidador");
        return repository.save(cuidador);
    }

    public Cuidador findById(Long id){

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuidador não encontrado"));
    }

    public Cuidador update(Cuidador cuidador){
        logger.info("Atualizando Cuidador");

        Cuidador entity = repository.findById(cuidador.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Cuidador não encontrado"));

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
        logger.info("Excluindo Cuidador");

        Cuidador entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuidador não encontrado"));

        repository.delete(entity);
    }


}
