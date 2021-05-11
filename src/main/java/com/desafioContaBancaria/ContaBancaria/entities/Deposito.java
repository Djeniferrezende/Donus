package com.desafioContaBancaria.ContaBancaria.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_transferencia")
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double Valor;

   @ManyToOne
   @JoinColumn(name="conta_id")
    private ContaBancaria conta;

    public Deposito(){

    }

    public Deposito(Long id, Double valor, ContaBancaria conta) {
        this.id = id;
        Valor = valor;
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }




}
