package com.desafioContaBancaria.ContaBancaria.repository;

import com.desafioContaBancaria.ContaBancaria.entities.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {

    @Query(value = "Select p.* from tb_conta p ORDER BY p.numero_conta desc limit 1", nativeQuery = true)
    ContaBancaria OrderByNumeroConta();


    boolean existsByCpf(String cpf);


}