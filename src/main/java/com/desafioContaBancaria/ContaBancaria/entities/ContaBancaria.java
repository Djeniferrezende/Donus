package com.desafioContaBancaria.ContaBancaria.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_conta")
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Integer numeroConta;
    private Double saldo;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    private List<Deposito> depositos;

    public ContaBancaria(){

    }

    public ContaBancaria(Long id, String nome, String cpf, Integer numeroConta, Double saldo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.numeroConta = numeroConta;
        this.saldo = saldo;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public Integer getNumeroConta() {

        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
