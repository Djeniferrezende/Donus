package com.desafioContaBancaria.ContaBancaria.repository;

import com.desafioContaBancaria.ContaBancaria.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
