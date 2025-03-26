package com.xCare.Service;

import com.xCare.Exception.ResourceNotFoundException;
import com.xCare.model.PacienteMedicamento;
import com.xCare.model.PacienteMedicamentoId;
import com.xCare.repository.PacienteMedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteMedicamentoService {

    @Autowired
    private PacienteMedicamentoRepository repository;

    public List<PacienteMedicamento> findAll() {
        return repository.findAll();
    }

    public PacienteMedicamento create(PacienteMedicamento pacienteMedicamento) {
        return repository.save(pacienteMedicamento);
    }

    public PacienteMedicamento findById(PacienteMedicamentoId id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PacienteMedicamento não encontrado"));
    }

    public PacienteMedicamento update(PacienteMedicamento pacienteMedicamento) {
        PacienteMedicamento entity = repository.findById(pacienteMedicamento.getId())
                .orElseThrow(() -> new ResourceNotFoundException("PacienteMedicamento não encontrado"));

        entity.setMedicamento(pacienteMedicamento.getMedicamento());
        entity.setPaciente(pacienteMedicamento.getPaciente());
        entity.setHorario(pacienteMedicamento.getHorario());
        entity.setQuantiaDose(pacienteMedicamento.getQuantiaDose());
        
        return repository.save(pacienteMedicamento);
    }

    public void delete(PacienteMedicamentoId id) {
        PacienteMedicamento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PacienteMedicamento não encontrado"));
        repository.delete(entity);
    }
}
