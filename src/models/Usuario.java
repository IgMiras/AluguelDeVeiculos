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
public class Usuario {
    
    // Removi codigoUsuario, pois terá um contador para Clientes e um para Funcionarios
    // Fiz isso porque no BD, existe uma tabela `cliente` e outra `funcionario` com auto-increment
    protected String nome;
    protected String cpf;
    protected String rg;
    protected LocalDate dataNasci;
    protected String endereco;
    protected String cep;
    protected String email;

    public Usuario(String nome, String cpf, String rg, String dataNasci, String endereco, String cep, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataOriginal = LocalDate.parse(dataNasci, formatter);
        this.dataNasci = dataOriginal;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
    }
    
    public String toString() {
		return "Nome: " + this.nome +
			   "\n CPF: " + this.cpf + " - RG: " + this.rg +
			   "\n Data de nascimento: " + this.dataNasci +
                           "\n Endereço: " + this.endereco + " - CEP: " + this.cep +
                           "\nEmail: " + this.email;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNasci() {
        return dataNasci;
    }

    public void setDataNasci(LocalDate dataNasci) {
        this.dataNasci = dataNasci;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
