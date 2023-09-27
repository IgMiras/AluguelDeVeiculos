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
public class Funcionario extends Usuario {
    
    protected static int codigoFuncionarioCounter = 1;
    protected int codigoFuncionario;
    protected float salario;
    protected String pis;
    protected LocalDate dataAdmissao;

    public Funcionario(String nome, String cpf, String rg, String dataNasci, String endereco, String cep, String email, float salario, String pis, String dataAdmissao) {
        super(nome, cpf, rg, dataNasci, endereco, cep, email);
        this.codigoFuncionario = codigoFuncionarioCounter;
        codigoFuncionarioCounter++; // Incrementa o contador para o próximo funcionário
        this.salario = salario;
        this.pis = pis;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataOriginal = LocalDate.parse(dataAdmissao, formatter);
        this.dataAdmissao = dataOriginal;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalário: R$" + this.salario + "\nPis: " + this.pis
                + "\nData de Admissão: " + this.dataAdmissao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

}
