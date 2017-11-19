/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoSistemaBancario.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class Agencia {
    private static int proxCod = 0;

    final private int codAgencia;
    private String endereco;
    private List<Cliente> clientes;

    public Agencia(String endereco) {
        this.codAgencia = ++Agencia.proxCod;
        this.endereco = endereco;
        this.clientes = new ArrayList<>();
    }
    
    public Agencia() {
        this.codAgencia = ++Agencia.proxCod;
        this.endereco = "Rua. Alves De Brito, 130";
        this.clientes = new ArrayList<>();
    }

    public int getCodAgencia() {
        return codAgencia;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    /**
     * Método responsavel por realizar o cadastro dos clientes na agencia.
     * 
     */
    public void cadastrarCliente() {
        this.clientes.add(new Cliente());
    }
    
    public Cliente localizarCliente(String cpf){
        Cliente clienteLocalizado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("Cliente localizado.");
                clienteLocalizado = cliente;
                break;
            }else{
                System.out.println("Cliente não localizado.");
            }
        }
        return clienteLocalizado;
    }
    
    /**
     * Método responsavel por realizar o cadastro de contas corrente atraves
     * do cliente.
     * 
     * @param cliente
     */
    public void cadastrarContaCorrente(Cliente cliente) {
        cliente.cadastrarContaCorrente(this.getCodAgencia());
    }

    /**
     * Método responsavel por realizar o cadastro de contas poupança atraves
     * do cliente.
     * 
     * @param cliente
     */
    public void cadastrarContaPoupanca(Cliente cliente) {
        cliente.cadastrarContaPoupanca(this.codAgencia);
    }

    /**
     * Método responsavel por realizar o cadastro de cartão de crédito atraves
     * do cliente.
     * 
     * @param cliente
     */
    public void cadastrarCartaoCredito(Cliente cliente) {
        cliente.cadastrarCartaoCredito();
    }
    
    /**
     * Método responsavel por realizar o cadastro de cartão de débito atraves
     * do cliente.
     * 
     * @param conta
     */
    public void cadastrarCartaoDebito(Conta conta) {
        conta.cadastrarCartaoDebito();
    }

    /**
     * Método responsavel por realizar o cadastro de emprestimo atraves
     * do cliente.
     * 
     * @param cliente
     */
    public void cadastrarEmprestimos(Cliente cliente) {
        cliente.cadastrarEmprestimos();
    }
}
