package com.desafioContaBancaria.ContaBancaria.config;

import com.desafioContaBancaria.ContaBancaria.entities.ContaBancaria;
import com.desafioContaBancaria.ContaBancaria.entities.Deposito;
import com.desafioContaBancaria.ContaBancaria.repository.ContaBancariaRepository;
import com.desafioContaBancaria.ContaBancaria.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

    @Autowired
    private ContaBancariaRepository repository;

    @Autowired
    private DepositoRepository depositoRepository;

    @Override
    public void run(String... args) throws Exception {



        ContaBancaria u1 = new ContaBancaria(null, "Djenifer","41756391874", 10000,5000.00);
        ContaBancaria u2 = new ContaBancaria(null, "Jonatas","123456789", 10001,7000.00);
        ContaBancaria u3 = new ContaBancaria(null, "Debora","26002880828", 10002,8000.00);

        repository.saveAll(Arrays.asList(u1,u2,u3));

        Deposito d1 = new Deposito(null, 500.00,u1);

        depositoRepository.saveAll(Arrays.asList(d1));



    }
}
