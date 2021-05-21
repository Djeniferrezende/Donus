package com.desafioContaBancaria.ContaBancaria.resource;

import com.desafioContaBancaria.ContaBancaria.entities.ContaBancaria;
import com.desafioContaBancaria.ContaBancaria.entities.Deposito;
import com.desafioContaBancaria.ContaBancaria.entities.Transferencia;
import com.desafioContaBancaria.ContaBancaria.service.ContaBancariaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/conta")
@Api(value="Api Rest Conta Bancaria")
//qualquer dominio pode acessar esse dominio
@CrossOrigin(origins = "*")
public class ContaBancariaResource {

    @Autowired
    private ContaBancariaService service;


    @GetMapping
    @ApiOperation(value ="Retorna lista de contas")
    public ResponseEntity<List<ContaBancaria>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    //buscar por id
    @GetMapping("/{id}")
    @ApiOperation(value ="Retorna produto unico")
    public ResponseEntity<ContaBancaria> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));

    }

    //deletar usuario
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value ="Deleta por id")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    @ApiOperation(value ="Salva conta")
    public ResponseEntity<ContaBancaria> salvar(@RequestBody ContaBancaria conta) {

        return ResponseEntity.ok().body(service.criarNovaConta(conta));
    }

    @PostMapping("{id}/novo-deposito")
    @ApiOperation(value ="faz deposito na conta bancaria")
    public ResponseEntity<ContaBancaria> depositar(@PathVariable Long id, @RequestBody Deposito deposito) {
        ContaBancaria conta = service.findById(id);
        service.novoDeposito(conta, deposito);
        return ResponseEntity.ok().body(conta);
    }

    @GetMapping("{id}/depositos")
    @ApiOperation(value ="Retorna lista de depositos")
    public ResponseEntity<List<Deposito>> depositos(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findDepositosByConta(id));
    }

    @PostMapping("{idOrigem}/nova-transferencia/{idDestino}")
    @ApiOperation(value ="faz uma transferencia")
    public ResponseEntity<Transferencia> transferir(@PathVariable Long idOrigem,@PathVariable Long idDestino, @RequestBody Transferencia transferencia) {
        ContaBancaria contaOrigem = service.findById(idOrigem);
        ContaBancaria contaDestino = service.findById(idDestino);
        service.tranfere(contaOrigem, contaDestino, transferencia);
        return ResponseEntity.ok().body(transferencia);
    }
}
