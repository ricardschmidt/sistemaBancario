/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoSistemaBancario.Controller;

import java.time.LocalDate;
import trabalhoSistemaBancario.Enum.Situacao;

/**
 *
 * @author Ricardo
 */
public class Parcela {
    final private int codParcela;
    final private LocalDate dtVencimento;
    final private double valor;
    private Situacao situacaoParcela;

    public Parcela(int codParcela, LocalDate dtVencimento, double valor) {
        this.codParcela = codParcela;
        this.dtVencimento = dtVencimento;
        this.valor = valor;
        this.situacaoParcela = Situacao.ABERTO;
    }

    public int getCodParcela() {
        return codParcela;
    }

    public LocalDate getDtVencimento() {
        return dtVencimento;
    }

    public double getValor() {
        return valor;
    }

    public Situacao getSituacaoParcela() {
        return situacaoParcela;
    }

    /**
     * Método responsavel por atualizar o status da parcela para PAGO.
     * 
     */
    public void pagarParcela() {
        this.situacaoParcela = Situacao.PAGO;
    }
    
    /**
     * Método responsavel por verificar o vencimento da parcela.
     * 
     * Caso a data de vencimento da parcela já tenha passado e a mesma não tenha
     * sido paga o método alterará a situação para VENCIDO.
     * 
     */
    public void verificaDataVencimento(){
        if (this.dtVencimento.isBefore(LocalDate.now()) && this.situacaoParcela != Situacao.PAGO) {
            this.situacaoParcela = Situacao.VENCIDO;
        }
    }
    
}
