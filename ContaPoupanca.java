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
public class ContaPoupanca extends Conta{
    List<Movimentacao> movimentacoes;
    double rendimento;

    public ContaPoupanca(double rendimento, int codAgencia, double saldo) {
        super(codAgencia, saldo);
        this.movimentacoes = new ArrayList<>();
        this.rendimento = rendimento;
    }

    public ContaPoupanca(double rendimento, int codAgencia) {
        super(codAgencia);
        this.movimentacoes = new ArrayList<>();
        this.rendimento = rendimento;
    }
    
    public ContaPoupanca(int codAgencia, double saldo) {
        super(codAgencia, saldo);
        this.movimentacoes = new ArrayList<>();
        this.rendimento = 0.001;
    }

    public ContaPoupanca(int codAgencia) {
        super(codAgencia);
        this.movimentacoes = new ArrayList<>();
        this.rendimento = 0.001;
    }
    
}
