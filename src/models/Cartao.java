/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Laís Isabella
 */
public class Cartao extends Pagamento{
    
    private String nome;
    private String bandeira;
    private String numero;
    private int ccv;

    public Cartao( String tipoPagamento, String nome, String bandeira, String numero, int ccv) {
        super(tipoPagamento);
        this.nome = nome;
        this.bandeira = bandeira;
        this.numero = numero;
        this.ccv = ccv;
    }
    
    @Override
    public String toString(){
        return "Pagamento realizado via cartão" + "\nPagador: " + this.nome + "\nCartão: " + this.bandeira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }
    
    
    
    
        
    
}
