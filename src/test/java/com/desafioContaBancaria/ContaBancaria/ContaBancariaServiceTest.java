package com.desafioContaBancaria.ContaBancaria;

import com.desafioContaBancaria.ContaBancaria.entities.ContaBancaria;
import com.desafioContaBancaria.ContaBancaria.entities.Deposito;
import com.desafioContaBancaria.ContaBancaria.repository.ContaBancariaRepository;
import com.desafioContaBancaria.ContaBancaria.repository.DepositoRepository;
import com.desafioContaBancaria.ContaBancaria.service.ContaBancariaService;
import com.desafioContaBancaria.ContaBancaria.service.exceptions.InvalidArgumentException;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

//spring boot + Junit
@RunWith(SpringRunner.class)
public class ContaBancariaServiceTest {

    @TestConfiguration
    static class ContaBancariaTestConfiguration{

        //instancia de conta Bancaria Service
        @Bean
        public ContaBancariaService contaService(){
            return new ContaBancariaService();
        }

    }
    @MockBean
    ContaBancariaRepository contaBancariaRepository;

    @MockBean
    DepositoRepository depositoRepository;

    @Autowired
    ContaBancariaService contaBancariaService;

    @Test
    public void cpfJaExiste(){
        ContaBancaria conta = new ContaBancaria(null, "Leticia","13981666852",null,500.00);
        Mockito.when(contaBancariaRepository.existsByCpf(conta.getCpf())).thenReturn(true);

        try{
            contaBancariaService.criarNovaConta(conta);
        }catch(RuntimeException e){
            Assert.assertEquals("CPF ja está cadastrado", e.getMessage());

        }
    }

    @Test
    public void cpfInvalido(){
        ContaBancaria conta = new ContaBancaria(null, "Leticia","13981666850",null,500.00);
        Mockito.when(contaBancariaRepository.existsByCpf(conta.getCpf())).thenReturn(false);

        try{
            contaBancariaService.criarNovaConta(conta);
        }catch(RuntimeException e){
           Assert.assertEquals("cpf invalido", e.getMessage());

        }
    }

    @Test
    public void numeroConta(){
        ContaBancaria conta = new ContaBancaria(null, "Leticia","42082227863",null,500.00);
        Mockito.when(contaBancariaRepository.existsByCpf(conta.getCpf())).thenReturn(false);
        Mockito.when(contaBancariaRepository.OrderByNumeroConta()).thenReturn(null);
        Mockito.when(contaBancariaRepository.save(conta)).thenReturn(null);

        contaBancariaService.criarNovaConta(conta);
        Assert.assertEquals(10000, (long) conta.getNumeroConta());
    }

    @Test
    public void depositoSuperiora2000(){


        ContaBancaria conta = new ContaBancaria(null, "Leticia","13981666852",null,500.00);
        Deposito deposito = new Deposito(null, 2500.00,conta);


        try{
            contaBancariaService.novoDeposito(conta, deposito);
        }catch(InvalidArgumentException e){
            Assert.assertEquals("Valor de deposito superior ao permitido", e.getMessage());

        }
    }




    @Before
    public void setup(){
    }


}
