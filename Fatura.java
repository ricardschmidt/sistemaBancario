/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoSistemaBancario.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import trabalhoSistemaBancario.Enum.Situacao;

/**
 *
 * @author Ricardo
 */
public class Fatura extends CartaoCredito{
    private List<Movimentacao> movimentacoes;
    private Situacao situacaoFatura;
    final private LocalDate dtVencimento;
    private static LocalDate proxDtVencimento = LocalDate.now().plusDays(7);

    public Fatura() {
        Fatura.proxDtVencimento = proxDtVencimento.plusMonths(1);
        this.movimentacoes = new ArrayList<>();
        this.situacaoFatura = Situacao.ABERTO;
        this.dtVencimento = proxDtVencimento;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public Situacao getSituacaoFatura() {
        return situacaoFatura;
    }

    public LocalDate getDtVencimento() {
        return dtVencimento;
    }

    public void setMovimentacoes(Movimentacao movimentacao) {
        this.movimentacoes.add(movimentacao);
    }

    public void faturaPaga() {
        this.situacaoFatura = Situacao.PAGO;
    }
    
    public void faturaFechada() {
        this.situacaoFatura = Situacao.FECHADO;
    }
    
    public void verificarVencimento(){
        if (this.dtVencimento.isBefore(LocalDate.now()) && this.situacaoFatura != Situacao.PAGO) {
            this.situacaoFatura = Situacao.VENCIDO;
        }
    }
    
    
    
    
}
