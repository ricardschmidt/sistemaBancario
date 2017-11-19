/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoSistemaBancario.Controller;

import java.util.ArrayList;
import java.util.List;
import trabalhoSistemaBancario.Enum.Situacao;

/**
 *
 * @author Ricardo
 */
public class Cliente {

    private static int proxCod = 0;

    final private int codCliente;
    final private String cpf;
    private double renda;
    private List<Conta> contas;
    private List<CartaoCredito> cartoes;
    private List<Emprestimo> emprestimos;

    public Cliente(String cpf, double renda) {
        this.codCliente = ++Cliente.proxCod;
        this.cpf = cpf;
        this.renda = renda;
        this.contas = new ArrayList<>();
        this.cartoes = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public Cliente() {
        this.codCliente = ++Cliente.proxCod;
        this.cpf = "000.111.222-33";
        this.renda = 10000;
        this.contas = new ArrayList<>();
        this.cartoes = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public int getCodCliente() {
        return codCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public double getRenda() {
        return renda;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public List<CartaoCredito> getCartoes() {
        return cartoes;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public void setContas(Conta conta) {
        this.contas.add(conta);
    }

    public void setCartoes(CartaoCredito cartao) {
        this.cartoes.add(cartao);
    }

    public void setEmprestimos(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }
    
    /**
     * Método responsavel por realizar o cadastro de contas corrente.
     * 
     * @param codAgencia
     */
    public void cadastrarContaCorrente(int codAgencia) {
        this.contas.add(new ContaCorrente(codAgencia));
        System.out.println("Conta Corrente cadastrada co sucesso.");
    }

    /**
     * Método responsavel por realizar o cadastro de contas poupança.
     * 
     * @param codAgencia
     */
    public void cadastrarContaPoupanca(int codAgencia) {
        this.contas.add(new ContaPoupanca(codAgencia));
        System.out.println("Conta Poupança cadastrada co sucesso.");
    }

    /**
     * Método responsavel por realizar o cadastro de cartão de crédito.
     * 
     */
    public void cadastrarCartaoCredito() {
        if (this.cartoes.size() > 5) {
            System.out.println("Você já possui o limite de cartões.");
        } else {
            this.cartoes.add(new CartaoCredito());
            System.out.println("Cartão cadastrado com sucesso.");
        }
    }

    /**
     * Método responsavel por realizar o cadastro de emprestimo.
     * 
     */
    public void cadastrarEmprestimos() {
        if (this.emprestimos.isEmpty()) {
            this.emprestimos.add(new Emprestimo());
            System.out.println("Emprestimo cadastrado com sucesso.");
        } else if (this.emprestimos.get(this.emprestimos.size() - 1).getSituacaoEmprestimo() == Situacao.ABERTO) {
            System.out.println("Já há um emprestimo aberto, não é possivel abrir outro.");
        } else {
            this.emprestimos.add(new Emprestimo());
            System.out.println("Emprestimo cadastrado com sucesso.");
        }
    }

}
