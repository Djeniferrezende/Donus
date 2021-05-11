package com.desafioContaBancaria.ContaBancaria.service;

import com.desafioContaBancaria.ContaBancaria.ValidaCpf;
import com.desafioContaBancaria.ContaBancaria.entities.ContaBancaria;
import com.desafioContaBancaria.ContaBancaria.entities.Deposito;
import com.desafioContaBancaria.ContaBancaria.repository.ContaBancariaRepository;
import com.desafioContaBancaria.ContaBancaria.repository.DepositoRepository;
import com.desafioContaBancaria.ContaBancaria.service.exceptions.DatabaseException;
import com.desafioContaBancaria.ContaBancaria.service.exceptions.InvalidArgumentException;
import com.desafioContaBancaria.ContaBancaria.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository repository;

    @Autowired
    private DepositoRepository depositoRepository;

    //listar contas
    public List<ContaBancaria> findAll() {
        return repository.findAll();
    }

    //buscar por id

    public ContaBancaria findById(Long id) {
        Optional<ContaBancaria> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    //deletar usuario

    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            //usuario tem uma conta, a conta precisa ser deletada para deletar o usuario
            throw new DatabaseException(e.getMessage());
        }
    }
    //atualizar

    public ContaBancaria update(Long id) {
        try {
            ContaBancaria conta = repository.getOne(id);
            conta.setNome(conta.getNome());
            return conta;

        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public ContaBancaria criarNovaConta(ContaBancaria conta) {

        // valida se a conta ja existe
        boolean valida = repository.existsByCpf(conta.getCpf());
        if(valida == true){
            throw new RuntimeException("CPF ja está cadastrado");
        }

        // valida o cpf
        if (!ValidaCpf.ValidaCpf(conta.getCpf())) {
            throw new RuntimeException("cpf invalido");
        }
        // seta o numero da conta
        ContaBancaria ultimaConta = repository.OrderByNumeroConta();
        if (ultimaConta == null) {
            conta.setNumeroConta(10000);
        } else {
            conta.setNumeroConta(ultimaConta.getNumeroConta() + 1);
        }

        return repository.save(conta);
    }

    public void novoDeposito(ContaBancaria conta , Deposito deposito) {
        if( deposito.getValor() > 2000){
            throw new InvalidArgumentException("Valor de deposito superior ao permitido");

        }
        conta.setSaldo(conta.getSaldo() + deposito.getValor());
        deposito.setConta(conta);
        repository.save(conta);
        depositoRepository.save(deposito);
    }

    //listar contas
    public List<Deposito> findAllDepositos(){
        return depositoRepository.findAll();
    }

    public List<Deposito> findDepositosByConta(Long id){
        return depositoRepository.findByContaId(id);
    }

}
