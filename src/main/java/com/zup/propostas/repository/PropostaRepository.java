package com.zup.propostas.repository;

import com.zup.propostas.modelo.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
     Optional<Proposta> findByEmail(String email);

     @Query("SELECT p FROM Proposta p WHERE p.status = 'ELEGIVEL' and p.cartao = null")
     List<Proposta> findEligibleProposesWithoutCard();
}
