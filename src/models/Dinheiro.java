/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Laís Isabella
 */
public class Dinheiro extends Pagamento {
    private int qtdCedulas;

    public Dinheiro(String tipoPagamento, int qtdCedulas) {
        super(tipoPagamento);
        this.qtdCedulas = qtdCedulas;
    }
    
    @Override
    public String toString(){
        return "Pagamento em dinheiro - " + this.qtdCedulas + " cedulas";
    }

    public int getQtdCedulas() {
        return qtdCedulas;
    }

    public void setQtdCedulas(int qtdCedulas) {
        this.qtdCedulas = qtdCedulas;
    }
    
    
    
    
    
    
}
