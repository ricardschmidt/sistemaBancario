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
public class ContaCorrente extends Conta{
    List<Movimentacao> movimentacoes;
    double chequeEspecial;

    public ContaCorrente(double chequeEspecial, int codAgencia, double saldo) {
        super(codAgencia, saldo);
        this.movimentacoes = new ArrayList<>();
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(double chequeEspecial, int codAgencia) {
        super(codAgencia);
        this.movimentacoes = new ArrayList<>();
        this.chequeEspecial = chequeEspecial;
    }
    
    public ContaCorrente(int codAgencia, double saldo) {
        super(codAgencia, saldo);
        this.movimentacoes = new ArrayList<>();
        this.chequeEspecial = 2000;
    }

    public ContaCorrente(int codAgencia) {
        super(codAgencia);
        this.movimentacoes = new ArrayList<>();
        this.chequeEspecial = 2000;
    }
    
}
