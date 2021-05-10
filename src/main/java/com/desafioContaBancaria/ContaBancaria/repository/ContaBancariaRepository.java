package com.desafioContaBancaria.ContaBancaria.repository;

import com.desafioContaBancaria.ContaBancaria.entities.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
}
