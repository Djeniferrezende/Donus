package com.desafioContaBancaria.ContaBancaria.entities;

import javax.persistence.*;

@Entity
@Table(name ="tb_transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conta_origem_id")
    private ContaBancaria contaOrigem;
    @ManyToOne
    @JoinColumn(name = "conta_destino_id")
    private ContaBancaria contaDestino;
    private Double valor;



    public Transferencia() {

    }

    public Transferencia(Long id, ContaBancaria contaOrigem, ContaBancaria contaDestino, Double valor) {
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContaBancaria getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaBancaria contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaBancaria getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaBancaria contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}



