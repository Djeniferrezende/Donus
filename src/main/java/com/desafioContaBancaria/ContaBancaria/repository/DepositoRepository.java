package com.desafioContaBancaria.ContaBancaria.repository;

import com.desafioContaBancaria.ContaBancaria.entities.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositoRepository extends JpaRepository<Deposito, Long> {
    List<Deposito> findByContaId(Long id);
}
