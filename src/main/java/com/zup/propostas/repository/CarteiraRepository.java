package com.zup.propostas.repository;

import com.zup.propostas.modelo.Carteira;
import com.zup.propostas.modelo.StatusCarteira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
    List<Carteira> findByStatusAndCartaoNumeroCartao(StatusCarteira status, String numero);
}
