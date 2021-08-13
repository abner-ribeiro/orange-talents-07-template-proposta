package com.zup.propostas.repository;

import com.zup.propostas.modelo.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
}
