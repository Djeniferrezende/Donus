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
        return ResponseEntity.ok().body(service.findAll());
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<ContaBancaria> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));

    }

    //deletar usuario
    @DeleteMapping( value = "/{id}")
    public  ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    //precisa ser revisto
    @PutMapping(value ="/{id}")
    public ResponseEntity<ContaBancaria> update(@PathVariable Long id, @RequestBody ContaBancaria conta){
        return ResponseEntity.ok().body(service.update(id));
    }

    @PostMapping
    public ResponseEntity<ContaBancaria> salvar(@RequestBody ContaBancaria conta){

        return ResponseEntity.ok().body(service.criarNovaConta(conta));
    }

}
