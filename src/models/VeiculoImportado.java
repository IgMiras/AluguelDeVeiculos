/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Windows
 */
public class VeiculoImportado extends Veiculo{
    protected float taxaImpostoEstadual;
    protected float taxaImpostoFederal;

    public VeiculoImportado() {}
    
    public VeiculoImportado(String nomeModelo, String montadora, int anoFabricacao, int anoModelo, String placa, String categoria, float valorFipe, float valorDiaria, String categoriaCNHNecessaria, float taxaImpostoEstadual, float taxaImpostoFederal) {
        super(nomeModelo, montadora, anoFabricacao, anoModelo, placa, categoria, valorFipe, valorDiaria, categoriaCNHNecessaria);
        this.taxaImpostoEstadual = taxaImpostoEstadual;
        this.taxaImpostoFederal = taxaImpostoFederal;
    }
    
    
    public float getTaxaImpostoEstadual() {
        return taxaImpostoEstadual;
    }

    public void setTaxaImpostoEstadual(float taxaImpostoEstadual) {
        this.taxaImpostoEstadual = taxaImpostoEstadual;
    }

    public float getTaxaImpostoFederal() {
        return taxaImpostoFederal;
    }

    public void setTaxaImpostoFederal(float taxaImpostoFederal) {
        this.taxaImpostoFederal = taxaImpostoFederal;
    }

    public float calcularValorDiaria(){
        // Implementar metodo
        
        return 0;
    };
    
    @Override
    public String toString(){
        String string = "VeiculoImportado{" + super.toString() + ", taxaImpostoEstadual=" + this.taxaImpostoEstadual + ", taxaImpostoFederal=" + this.taxaImpostoFederal + "}";
        return string;
    }
}

