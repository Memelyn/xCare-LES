package com.xCare.repository;

import com.xCare.model.CuidadorPaciente;
import com.xCare.model.CuidadorPacienteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuidadorPacienteRepository extends JpaRepository<CuidadorPaciente, CuidadorPacienteId> {
}
