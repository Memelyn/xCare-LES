package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.Endereco;
import com.xCare.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class EnderecoServices {
   // private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(EnderecoServices.class.getName());

    @Autowired
    EnderecoRepository repository;

    public List<Endereco> findAll(){

        logger.info("Procurando Enderecos");

        return repository.findAll();

    }

    public Endereco create(Endereco endereco){
        logger.info("Criando Endereco");
        return repository.save(endereco);
    }

    public Endereco findById(Long id){

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereco não encontrado"));
    }

    public Endereco update(Endereco endereco){
        logger.info("Atualizando Endereco");

        Endereco entity = repository.findById(endereco.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Endereco não encontrado"));

        entity.setTipoLogradouro(endereco.getTipoLogradouro());
        entity.setNomeLogradouro(endereco.getNomeLogradouro());
        entity.setNumeroLogradouro(endereco.getNumeroLogradouro());
        entity.setComplemento(endereco.getComplemento());
        entity.setBairro(endereco.getBairro());
        entity.setCep(endereco.getCep());

        return repository.save(endereco);
    }

    public void delete(Long id){
        logger.info("Excluindo Endereco");

        Endereco entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereco não encontrado"));

        repository.delete(entity);
    }


}
