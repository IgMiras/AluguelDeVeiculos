/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Laís Isabella
 */
public class Cliente extends Usuario {
    
    protected static int codigoClienteCounter = 1;
    protected int codigoCliente;
    protected String categoriaCNH;
    protected String numeroCNH;
    protected LocalDate validadeCNH;
    protected boolean clienteOuro;
    
    public Cliente(){}
    
    public Cliente(String nome, String cpf, String rg, String dataNasci, String endereco, String cep, String email, String categoriaCNH, String numeroCNH, String validadeCNH, boolean clienteOuro) {
        super(nome, cpf, rg, dataNasci, endereco, cep, email);
        this.codigoCliente = codigoClienteCounter;
        codigoClienteCounter++; // Incrementa o contador para o próximo Cliente
        this.categoriaCNH = categoriaCNH;
        this.numeroCNH = numeroCNH;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataOriginal = LocalDate.parse(validadeCNH, formatter);
        this.validadeCNH = dataOriginal;
        this.clienteOuro = clienteOuro;
    }

    @Override
    public String toString() {
        if (this.clienteOuro == true) {
            return super.toString() + "\nCategoria de CNH: " + this.categoriaCNH + " - Número da CNH: " + this.numeroCNH
                    + "\nData da validade da CNH: " + this.validadeCNH + "\nCLIENTE OURO" + "\n\n";
        } else {
            return super.toString() + "\nCategoria de CNH: " + this.categoriaCNH + " - Número da CNH: " + this.numeroCNH
                    + "\nData da validade da CNH: " + this.validadeCNH + "\n\n";
        }
    }

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public LocalDate getValidadeCNH() {
        return validadeCNH;
    }

    public void setValidadeCNH(LocalDate validadeCNH) {
        this.validadeCNH = validadeCNH;
    }

    public boolean isClienteOuro() {
        return clienteOuro;
    }

    public void setClienteOuro(boolean clienteOuro) {
        this.clienteOuro = clienteOuro;
    }

}
