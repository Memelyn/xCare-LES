package com.xCare.repository;

import com.xCare.model.EnderecoItemMedico;
import com.xCare.model.EnderecoItemMedicoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoItemMedicoRepository extends JpaRepository<EnderecoItemMedico, EnderecoItemMedicoId> {
}
