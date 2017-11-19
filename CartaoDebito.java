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
public class CartaoDebito extends Cartao {

    private List<Movimentacao> movimentacoes;

    public CartaoDebito() {
        super();
        this.movimentacoes = new ArrayList<>();
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    /**
     * Método utilizado para salvar movimentações.
     *
     * @param movimentacao
     */
    public void salvaMovimentacao(Movimentacao movimentacao) {
        this.movimentacoes.add(movimentacao);
        System.out.println("Movimentação salva com sucesso.");
    }

    /**
     * Método utilizado para realziar compras.
     *
     * Este método verifica a data de vencimento e senha do cartão e o saldo da
     * conta para realizar a compra.
     *
     * @param valorCompra
     * @param conta
     * @param senha
     */
    public void realizarCompra(double valorCompra, Conta conta, int senha) {
        if (super.verificaDataVencimento()) {
            if (senha == super.getSenha()) {
                if (valorCompra < conta.saldo) {

                } else {
                    System.out.println("Compra não autorizada. Saldo Insuficiente.");
                }
            } else {
                System.out.println("Compra não autorizada. Senha incorreta.");
            }
        } else {
            System.out.println("Compra não autorizada. Cartão Vencido.");
        }
    }
}
