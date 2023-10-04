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
    
    public VeiculoNacional(){}
    
    public VeiculoNacional(String tipoVeiculo, String nomeModelo, String montadora, int anoFabricacao, 
            int anoModelo, String placa, String categoria, float valorFipe, float valorDiaria, String categoriaCNHNecessaria, float taxaImpostoEstadual) {
        super(tipoVeiculo, nomeModelo, montadora, anoFabricacao, anoModelo, placa, categoria, valorFipe, valorDiaria, categoriaCNHNecessaria);
        this.taxaImpostoEstadual = taxaImpostoEstadual;
    }

    public float getTaxaImpostoEstadual() {
        return taxaImpostoEstadual;
    }

    public void setTaxaImpostoEstadual(float taxaImpostoEstadual) {
        this.taxaImpostoEstadual = taxaImpostoEstadual;
    }

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
        // Fui obrigado a implementar por ser abstract na classe pai
        // NAO USAR!
        return 0;
    }

    @Override
    public void setTaxaImpostoFederal(float taxaImpostoFederal) {
        // Fui obrigado a implementar por ser abstract na classe pai
        // NAO USAR!
    }
    
}

