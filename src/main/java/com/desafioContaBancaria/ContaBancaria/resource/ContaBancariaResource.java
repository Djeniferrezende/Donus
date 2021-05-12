package com.desafioContaBancaria.ContaBancaria.resource;

import com.desafioContaBancaria.ContaBancaria.entities.ContaBancaria;
import com.desafioContaBancaria.ContaBancaria.entities.Deposito;
import com.desafioContaBancaria.ContaBancaria.entities.Transferencia;
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
    public ResponseEntity<List<ContaBancaria>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<ContaBancaria> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));

    }

    //deletar usuario
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<ContaBancaria> salvar(@RequestBody ContaBancaria conta) {

        return ResponseEntity.ok().body(service.criarNovaConta(conta));
    }

    @PostMapping("{id}/novo-deposito")
    public ResponseEntity<ContaBancaria> depositar(@PathVariable Long id, @RequestBody Deposito deposito) {
        ContaBancaria conta = service.findById(id);
        service.novoDeposito(conta, deposito);
        return ResponseEntity.ok().body(conta);
    }

    @GetMapping("{id}/depositos")
    public ResponseEntity<List<Deposito>> depositos(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findDepositosByConta(id));
    }

    @PostMapping("{idOrigem}/nova-transferencia/{idDestino}")
    public ResponseEntity<Transferencia> transferir(@PathVariable Long idOrigem,@PathVariable Long idDestino, @RequestBody Transferencia transferencia) {
        ContaBancaria contaOrigem = service.findById(idOrigem);
        ContaBancaria contaDestino = service.findById(idDestino);
        service.tranfere(contaOrigem, contaDestino, transferencia);
        return ResponseEntity.ok().body(transferencia);
    }
}
