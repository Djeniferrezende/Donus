package com.desafioContaBancaria.ContaBancaria;

import com.desafioContaBancaria.ContaBancaria.entities.ContaBancaria;
import com.desafioContaBancaria.ContaBancaria.repository.ContaBancariaRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContaBancariaRespositoryTest {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    //quais excessoes estao acontecendo no test
   /* @Rule
    private ExpectedException thrown = ExpectedException.none();
*/

    @Test
    public void deveSalvarUmaConta(){
        ContaBancaria contaBancaria = new ContaBancaria(null, "Leticia","13981666852",null,500.00);
        this.contaBancariaRepository.save(contaBancaria);

        Assertions.assertThat(contaBancaria.getId()).isNotNull();
        Assertions.assertThat(contaBancaria.getNome()).isEqualTo("Leticia");
        Assertions.assertThat(contaBancaria.getCpf()).isEqualTo("13981666852");
        Assertions.assertThat(contaBancaria.getNumeroConta()).isEqualTo(null);
        Assertions.assertThat(contaBancaria.getSaldo()).isEqualTo(500.00);
    }


}
