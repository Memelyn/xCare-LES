package com.xCare.repository;

import com.xCare.model.EnderecoMedicamento;
import com.xCare.model.EnderecoMedicamentoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoMedicamentoRepository extends JpaRepository<EnderecoMedicamento, EnderecoMedicamentoId> {
}
