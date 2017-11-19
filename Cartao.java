/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoSistemaBancario.Controller;

import java.time.LocalDate;

/**
 *
 * @author Ricardo
 */
abstract class Cartao {
    final private String numCartao;
    private int senha;
    final private int cvv;
    final private LocalDate dtValidade;

    public Cartao() {
        this.numCartao = gerarNumeroCartao();
        this.senha = gerarSenha();
        this.cvv = gerarCVV();
        this.dtValidade = gerarDataValidade();
    }
    
    public String getNumCartao() {
        return numCartao;
    }

    public int getSenha() {
        return senha;
    }

    public int getCvv() {
        return cvv;
    }

    public LocalDate getDtValidade() {
        return dtValidade;
    }

    /**
     * Método responsavel por alterar a senha do cartão.
     * 
     * Não há verificação para que não seja colocada senhas sequenciais ou
     * senha igual a anterior.
     * 
     * @param senha
     */
    public void alterarSenha(int senha) {
        this.senha = senha;
    }
    
    /**
     * Método responsavel por gerar o número do cartão.
     * 
     * O método gerá uma String que conterá 19 carcteres que formaram os 16
     * números do cartão de crédito, separado em blocos de 4.
     * 
     * Os números são gerados aleatoriamente e não há conferencia para verificar
     * se o número já existe.
     * 
     */
    static String gerarNumeroCartao(){
        String num = "";
        for (int i = 0; i < 19; i++) {
            if (i == 4 || i == 9  ||  i == 14) {
                num += " ";
            }else{
                num += Math.random()*10;
            }
        }
        return num;
    }
    
    /**
     * Método responsavel por gerar o código de segurança do cartão.
     * 
     * Código é gerado aleatóriamente.
     * 
     */
    static int gerarCVV(){
        int num = (int)(Math.random() * 900 + 100);
        return num;
    }
    
    /**
     * Método responsavel por gerar a senha do cartão.
     * 
     * Senha é gerada aleatóriamente.
     * 
     */
    static int gerarSenha(){
        int num = (int)(Math.random() * 9000 + 1000);
        return num;
    }
    
    /**
     * Método responsavel por gerar a data de vencimento do cartão.
     * 
     * Sempre é acrescentado 5 anos apartir da data em que o cartão é gerado.
     * 
     */
    static LocalDate gerarDataValidade(){
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("MM/yy");
        LocalDate data = LocalDate.now().plusYears(5);
        
        return data;
    }
    
    /**
     * Método utilizado para verificar a data de vencimento do cartão.
     *
     * @return 
     */
    protected boolean verificaDataVencimento() {
        return getDtValidade().isAfter(LocalDate.now());

    }
    
}
