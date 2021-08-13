package com.zup.propostas.repository;

import com.zup.propostas.modelo.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
     Optional<Proposta> findByDocumento(String documento);
}
