/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Laís Isabella
 */
public abstract class Pagamento {
    private String tipoPagamento;

    public Pagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    public abstract String toString();

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

   
    
    
    
    
}
