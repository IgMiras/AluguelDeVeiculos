/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Windows
 */
public class Locacao {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private static int codigoLocacaoCounter = 1;
    private int codigoLocacao;
    private int codigoCliente;
    private int codigoFuncionario;
    private Veiculo veiculo;
    
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private float valorTotal;
    private String tipoPagamento;
    private ArrayList<Seguro> segurosContratados;
    private boolean finalizada;
    
    public Locacao(){}
    
    public Locacao(int codigoCliente, int codigoFuncionario, Veiculo veiculo, String dataLocacao, String dataDevolucao, float valorTotal, String tipoPagamento, ArrayList<Seguro> segurosContratados) {
        this.codigoLocacao = codigoLocacaoCounter;
        codigoLocacaoCounter++; // Incrementa o contador para a proxima Locacao
        this.codigoCliente = codigoCliente;
        this.codigoFuncionario = codigoFuncionario;
        this.veiculo = veiculo;
        LocalDate dataLocacaoAux = LocalDate.parse(dataLocacao, formatter);
        this.dataLocacao = dataLocacaoAux;
        LocalDate dataDevolucaoAux = LocalDate.parse(dataDevolucao, formatter);
        this.dataDevolucao = dataDevolucaoAux;
        this.tipoPagamento = tipoPagamento;
        this.segurosContratados = segurosContratados;
        this.finalizada = false;
        calcularValorTotal();
    }
    
    public int getCodigoVeiculo(){
        return this.veiculo.getCodigoVeiculo();
    }
    
    public int getCodigoLocacao() {
        return codigoLocacao;
    }

    public void setCodigoLocacao(int codigoLocacao) {
        this.codigoLocacao = codigoLocacao;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public ArrayList<Seguro> getSegurosContratados() {
        return segurosContratados;
    }

    public void setSegurosContratados(ArrayList<Seguro> segurosContratados) {
        this.segurosContratados = segurosContratados;
    }

    public boolean estaFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public float calcularValorTotal(){
        long diferencaEmDias = Math.abs(this.dataLocacao.toEpochDay() - this.dataDevolucao.toEpochDay());
        float valorSeguros = 0;
        for (Seguro seguro : this.segurosContratados){
            valorSeguros = valorSeguros + seguro.getValor();
        }
        float valorFinal = diferencaEmDias * veiculo.getValorDiaria() + valorSeguros;
        this.valorTotal = valorFinal;
        return valorFinal;
    }
    

    public boolean possuiSeguro(){
        return !this.segurosContratados.isEmpty();
    }
    
    public boolean verificarAtraso(){
        if (LocalDate.now().isAfter(this.dataDevolucao) && this.finalizada == false){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Locacao{" + "formatter=" + formatter + ", codigoLocacao=" + codigoLocacao +
                ", codigoCliente=" + codigoCliente + ", codigoFuncionario=" + codigoFuncionario +
                ", veiculo=" + veiculo.toString() + ", dataLocacao=" + dataLocacao +
                ", dataDevolucao=" + dataDevolucao + ", valorTotal=" + valorTotal + ", tipoPagamento=" + tipoPagamento +
                ", segurosContratados=" + segurosContratados + ", finalizada=" + finalizada + '}';
    }
    
    
    
}

