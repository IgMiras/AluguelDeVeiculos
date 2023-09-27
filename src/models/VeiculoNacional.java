/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Windows
 */
public class VeiculoNacional extends Veiculo{
    protected float taxaImpostoEstadual;

    public VeiculoNacional(String nomeModelo, String montadora, int anoFabricacao, int anoModelo, String placa, String categoria, float valorFipe, float valorDiaria, String categoriaCNHNecessaria, float taxaImpostoEstadual) {
        super(nomeModelo, montadora, anoFabricacao, anoModelo, placa, categoria, valorFipe, valorDiaria, categoriaCNHNecessaria);
        this.taxaImpostoEstadual = taxaImpostoEstadual;
    }

    public float getTaxaImpostoEstadual() {
        return taxaImpostoEstadual;
    }

    public void setTaxaImpostoEstadual(float taxaImpostoEstadual) {
        this.taxaImpostoEstadual = taxaImpostoEstadual;
    }

    @Override
    public float calcularValorDiaria(){
        // Implementar metodo
        
        return 0;
    };

    @Override
    public String toString() {
        String string = "VeiculoNacional{" + super.toString() + ", taxaImpostoEstadual=" + this.taxaImpostoEstadual + "}";
        return string;
    }

    @Override
    public float getTaxaImpostoFederal() {
        // Fui obrigado a implementar por ser metodo abstrato na classe pai
        // NAO CHAMAR ESTE METODO!
        // POG (Programação Orientada a Gambiarra)
        return 0;
    }
    
    
}

