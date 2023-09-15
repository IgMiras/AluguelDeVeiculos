/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Windows
 */
public class Seguro {
    private int codigoSeguro;
    private String nome;
    private String tipo;
    private String descricao;
    private float valor;

    public Seguro(int codigoSeguro, String nome, String tipo, String descricao, float valor) {
        this.codigoSeguro = codigoSeguro;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigoSeguro() {
        return codigoSeguro;
    }

    public void setCodigoSeguro(int codigoSeguro) {
        this.codigoSeguro = codigoSeguro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String toString() {
        return "Seguro: " + this.nome + " - Código: " + this.codigoSeguro 
               + "\nTipo: " + this.tipo + " - Valor: R$ " + this.valor +
                "\nDescrição: " + this.descricao;
    }
}