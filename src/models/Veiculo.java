/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Windows
 */
public abstract class Veiculo {
    
    protected static int codigoVeiculoCounter = 1;
    protected int codigoVeiculo;
    protected String nomeModelo;
    protected String montadora;
    protected int anoFabricacao;
    protected int anoModelo;
    protected String placa;
    protected String categoria;
    protected float valorFipe;
    protected float valorDiaria;
    protected String categoriaCNHNecessaria;
    protected boolean alugado;
    protected String tipoVeiculo;
    
    public Veiculo(){}
    
    public Veiculo(String tipoVeiculo,String nomeModelo, String montadora, int anoFabricacao, int anoModelo, String placa, String categoria, float valorFipe, float valorDiaria, String categoriaCNHNecessaria) {
        this.tipoVeiculo = tipoVeiculo;
        this.codigoVeiculo = codigoVeiculoCounter;
        codigoVeiculoCounter++; // Incrementa o contador para o próximo Veiculo
        this.nomeModelo = nomeModelo;
        this.montadora = montadora;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.placa = placa;
        this.categoria = categoria;
        this.valorFipe = valorFipe;
        this.valorDiaria = valorDiaria;
        this.categoriaCNHNecessaria = categoriaCNHNecessaria;
        this.alugado = false;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
    
    public int getCodigoVeiculo() {
        return codigoVeiculo;
    }

    public void setCodigoVeiculo(int codigoVeiculo) {
        this.codigoVeiculo = codigoVeiculo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(float valorFipe) {
        this.valorFipe = valorFipe;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getCategoriaCNHNecessaria() {
        return categoriaCNHNecessaria;
    }

    public void setCategoriaCNHNecessaria(String categoriaCNHNecessaria) {
        this.categoriaCNHNecessaria = categoriaCNHNecessaria;
    }

    public void setAlugado(Boolean alugado) {
        this.alugado = alugado;
    }
    
    //public abstract float calcularValorDiaria();
    
    public boolean estaAlugado(){
        return this.alugado;
    }
    
    public void alugar(){
        // implementar logicas necessarias
        this.alugado = true;
    }
    
    public void devolver(){
        // implementar logicas necessarias
        this.alugado = false;
    }

    @Override
    public String toString() {
        return "Código do véiculo: " + codigoVeiculo + 
                "\nNome Modelo: " + nomeModelo + 
                "\nMontadora: " + montadora + 
                "\nAno de Fabricacao: " + anoFabricacao + 
                "\nAno do Modelo: " + anoModelo +
                "\nPlaca: " + placa +
                "\nCategoria: " + categoria + 
                "\nValor Fipe: " + valorFipe + 
                "\nValor da Diaria=" + valorDiaria + 
                "\nCategoria de CNH Necessaria: " + categoriaCNHNecessaria + 
                "\nAlugado: " + alugado;
    }
    
    public abstract float getTaxaImpostoEstadual();
    
    public abstract float getTaxaImpostoFederal();
    
    public abstract void setTaxaImpostoEstadual(float taxaImpostoEstadual);
    
    public abstract void setTaxaImpostoFederal(float taxaImpostoFederal);
    
}
