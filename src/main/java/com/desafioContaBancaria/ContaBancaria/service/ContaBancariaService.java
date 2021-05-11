package com.desafioContaBancaria.ContaBancaria.service;

import com.desafioContaBancaria.ContaBancaria.entities.ContaBancaria;
import com.desafioContaBancaria.ContaBancaria.repository.ContaBancariaRepository;
import com.desafioContaBancaria.ContaBancaria.service.exceptions.DatabaseException;
import com.desafioContaBancaria.ContaBancaria.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository repository;

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

    public void deletar(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            //usuario tem uma conta, a conta precisa ser deletada para deletar o usuario
            throw new DatabaseException(e.getMessage());
        }
    }

}
