package com.desafioContaBancaria.ContaBancaria.config;

import com.desafioContaBancaria.ContaBancaria.entities.ContaBancaria;
import com.desafioContaBancaria.ContaBancaria.repository.ContaBancariaRepository;
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

    @Override
    public void run(String... args) throws Exception {



        ContaBancaria u1 = new ContaBancaria(null, "Djenifer","41756391874", 10000,5.000);
        ContaBancaria u2 = new ContaBancaria(null, "Jonatas","123456789", 10001,7.000);
        ContaBancaria u3 = new ContaBancaria(null, "Debora","26002880828", 10002,8.000);

        repository.saveAll(Arrays.asList(u1,u2,u3));

    }
}
