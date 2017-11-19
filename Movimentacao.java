/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoSistemaBancario.Controller;

import java.time.LocalDate;
import trabalhoSistemaBancario.Enum.TipoMovimentacao;

/**
 *
 * @author Ricardo
 */
public class Movimentacao {
    final private TipoMovimentacao tipoMovimentacao;
    final private double valor;
    final private LocalDate date;

    public Movimentacao(TipoMovimentacao tipoMovimentacao, double valor) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.valor = valor;
        this.date = LocalDate.now();
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDate() {
        return date;
    }
    
    
    
    
}
