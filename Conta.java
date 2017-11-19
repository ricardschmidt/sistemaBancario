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
abstract class Conta {
    static int proxNumConta = 0;
    int codAgencia;
    final int numConta;
    int senha;
    List<CartaoDebito> cartoes;
    double saldo;

    protected Conta(int codAgencia, double saldo) {
        this.codAgencia = codAgencia;
        this.numConta = ++proxNumConta;
        this.senha = gerarSenha();
        this.cartoes = new ArrayList<>();
        this.saldo = saldo;
    }
    
    protected Conta(int codAgencia) {
        this.codAgencia = codAgencia;
        this.numConta = ++proxNumConta;
        this.senha = gerarSenha();
        this.cartoes = new ArrayList<>();
        this.saldo = 0;
    }
    
    static int gerarSenha(){
        int num = (int)(Math.random() * 9000 + 1000);
        return num;
    }
    
    /**
     * Método responsavel por realizar o cadastro de cartão de débito.
     * 
     */
    public void cadastrarCartaoDebito() {
        if (this.cartoes.size() > 5) {
            System.out.println("Você já possui o limite de cartões.");
        } else {
            this.cartoes.add(new CartaoDebito());
            System.out.println("Cartão cadastrado com sucesso.");
        }

    }
    
}
