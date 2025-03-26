package com.xCare.repository;

import com.xCare.model.PacienteMedicamento;
import com.xCare.model.PacienteMedicamentoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteMedicamentoRepository extends JpaRepository<PacienteMedicamento, PacienteMedicamentoId> {
}
