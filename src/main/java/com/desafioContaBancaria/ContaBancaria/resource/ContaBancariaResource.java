package com.desafioContaBancaria.ContaBancaria.resource;

import com.desafioContaBancaria.ContaBancaria.entities.ContaBancaria;
import com.desafioContaBancaria.ContaBancaria.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/conta")
public class ContaBancariaResource {

    @Autowired
    private ContaBancariaService service;


    @GetMapping
    public ResponseEntity<List<ContaBancaria>> findAll(){
        List<ContaBancaria> user = service.findAll();
        return ResponseEntity.ok().body(user);
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<ContaBancaria> findById(@PathVariable Long id) {
        ContaBancaria conta = service.findById(id);
        return ResponseEntity.ok().body(conta);

    }

    //deletar usuario
    @DeleteMapping( value = "/{id}")
    public  ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
