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
public class CartaoCredito extends Cartao {

    private List<Fatura> faturas;
    private double limite;
    private int atualizacaoLimite = 0;

    public CartaoCredito(double limite) {
        this.faturas = new ArrayList<>();
        this.limite = limite;
    }

    public CartaoCredito() {
        this.faturas = new ArrayList<>();
        this.limite = 2000;
    }

    public List<Fatura> getFaturas() {
        return faturas;
    }

    public double getLimite() {
        return limite;
    }

    /**
     * Método utilizado para atualizar o limite do cartão.
     *
     * O limite é atualizado conforme o cartão é utilizado, quanto mais
     * movimentações maior o limite para compras.
     *
     */
    private void atualizaLimite() {
        int totalMovimentacao = 0;
        for (Fatura fatura : faturas) {
            totalMovimentacao += fatura.getMovimentacoes().size();
        }

        if (totalMovimentacao >= 10 && totalMovimentacao < 20 && this.atualizacaoLimite == 0) {
            this.limite += this.limite * 0.50;
            this.atualizacaoLimite++;
        } else if (totalMovimentacao >= 20 && totalMovimentacao < 50 && this.atualizacaoLimite == 1) {
            this.limite += this.limite * 0.50;
        } else if (totalMovimentacao >= 50 && totalMovimentacao < 100 && this.atualizacaoLimite == 2) {
            this.limite += this.limite * 0.50;
        } else if (totalMovimentacao >= 100 && this.atualizacaoLimite == 3) {
            this.limite += this.limite * 0.50;
        }

    }

    /**
     * Método utilizado para realziar compras.
     *
     * Este método verifica a data de vencimento e senha e limite do cartão
     * para realizar a compra.
     * 
     * Aqui são criadas as faturas do cartão, verificando se já há uma em aberto,
     * caso tenha é adicionado apenas uma nova movimentação na atual, caso não
     * tenha nenhuma fatura ou a atual já está na data de fechamento é criado uma nova.
     * 
     * @param valorCompra
     * @param senha
     * @return
     */
    public boolean comprar(double valorCompra, int senha) {
        verificarFaturas();
        if (super.verificaDataVencimento()) {
            if (senha == super.getSenha()) {
                if (valorCompra < this.limite) {
                    if (this.faturas.isEmpty()){
                       this.faturas.add(new Fatura());
                    }else if(LocalDate.now().isAfter(faturas.get(faturas.size() - 1).getDtValidade().minusDays(7))) {
                        this.faturas.get(this.faturas.size() - 1).faturaFechada();
                        this.faturas.add(new Fatura());
                    }else{
                        this.faturas.get(faturas.size() - 1);
                    }
                    atualizaLimite();
                    return true;
                } else {
                    System.out.println("Compra não autorizada. Saldo Insuficiente.");
                    return false;
                }
            } else {
                System.out.println("Compra não autorizada. Senha incorreta.");
                return false;
            }
        } else {
            System.out.println("Compra não autorizada. Cartão Vencido.");
            return false;
        }
        
    }
    
    /**
     * Método utilizado para pagar fatura do Cartão de Crédito.
     *
     * As faturas só poderão ser pagas se já estiverem fechada ou vencidas.
     *
     * @param fatura
     */
    public void pagarFatura(Fatura fatura){
        if (fatura.getSituacaoFatura() == Situacao.FECHADO || fatura.getSituacaoFatura() == Situacao.VENCIDO) {
            fatura.faturaPaga();
            System.out.println("Fatura paga com sucesso.");
        }else{
            System.out.println("Sua fatura não está fechada ou vencida.");
        }
        verificarFaturas();
    }
    
    /**
     * Método responsavel por varrer as faturas e verificar se há alguma VENCIDA.
     * 
     */
    private void verificarFaturas(){
        for (Fatura fatura : faturas) {
            fatura.verificaDataVencimento();
        }
    }
}
