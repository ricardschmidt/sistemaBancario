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
public class Emprestimo {
    private static int proxCod = 0;

    final private int codEmprestimo;
    final private double taxa;
    final private double valor;
    final private int prazo;
    private Situacao situacaoEmprestimo;
    final private LocalDate data;
    private List<Parcela> parcelas;

    public Emprestimo(double taxa, double valor, int prazo) {
        this.codEmprestimo = ++Emprestimo.proxCod;
        this.taxa = taxa;
        this.valor = valor;
        this.prazo = prazo;
        this.situacaoEmprestimo = Situacao.ABERTO;
        this.data = dataAtual();
        this.parcelas = new ArrayList<>();
    }
    
    public Emprestimo() {
        this.codEmprestimo = ++Emprestimo.proxCod;
        this.taxa = 0.05;
        this.valor = 10000;
        this.prazo = 24;
        this.situacaoEmprestimo = Situacao.ABERTO;
        this.data = dataAtual();
        this.parcelas = new ArrayList<>();
    }
    
    /**
     * Método responsavel por gerar a data atual de acordo com o computador.
     * 
     * @return 
     */
    public static LocalDate dataAtual(){
//        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.now();
        
        return data;
    }

    public LocalDate getData() {
        return data;
    }

    public int getCodEmprestimo() {
        return codEmprestimo;
    }

    public double getTaxa() {
        return taxa;
    }

    public double getValor() {
        return valor;
    }

    public int getPrazo() {
        return prazo;
    }

    public Situacao getSituacaoEmprestimo() {
        return situacaoEmprestimo;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }
    
    /**
     * Método responsavel por gerar as parcelas do emprestimo.
     * 
     * O método calcula o valor de cada parcela de acordo com o prazo de 
     * pagamento do emprestimo.
     * 
     */
    public void geraParcelas() {
        double valorParcela = this.valor / this.prazo;
        for (int i = 0; i < this.prazo; i++) {
            this.parcelas.add(new Parcela(i + 1, this.data.plusMonths(i + 1) ,valorParcela));
            
        }
        System.out.println("Parcelas Geradas.");
        verificarParcelas();
    }

    /**
     * Método responsavel atualizar o status do emprestimo para PAGO.
     * 
     */
    public void emprestimoPago() {
        this.situacaoEmprestimo = Situacao.PAGO;
        System.out.println("Emprestimo Pago.");
        verificarParcelas();
    }
    
    /**
     * Método responsavel por varrer as parcelas e verificar se há alguma VENCIDA.
     * 
     */
    private void verificarParcelas(){
        for (Parcela parcela : parcelas) {
            parcela.verificaDataVencimento();
        }
    }
    
}
