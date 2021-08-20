package com.zup.propostas.repository;

import com.zup.propostas.modelo.Cartao;
import com.zup.propostas.modelo.StatusCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    Optional<Cartao> findByNumeroCartao(String numeroCartao);
}
