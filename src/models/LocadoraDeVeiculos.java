/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class LocadoraDeVeiculos {
    private String nome;
    private String endereco;
    private String website;
    private String redeSocial;
    private ArrayList<Locacao> locacoes;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Usuario> clientes;
    private ArrayList<Usuario> funcionarios;
    private ArrayList<Seguro> seguros;
    private static LocadoraDeVeiculos instancia = null;

    // Nao usei um atributo de Configuracoes pois todos os atributos de config serao Static e Final.
    public LocadoraDeVeiculos(String nome, String endereco, String website, String redeSocial) {
        this.nome = nome;
        this.endereco = endereco;
        this.website = website;
        this.redeSocial = redeSocial;
        this.locacoes = new ArrayList<Locacao>();
        this.veiculos = new ArrayList<Veiculo>();
        this.clientes = new ArrayList<Usuario>();
        this.funcionarios = new ArrayList<Usuario>();
        this.seguros = new ArrayList<Seguro>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    public ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(ArrayList<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public ArrayList<Usuario> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Usuario> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Usuario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Usuario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(ArrayList<Seguro> seguros) {
        this.seguros = seguros;
    }

    public static LocadoraDeVeiculos getInstancia(String aluguelDeVeiculos, String s, String s1, String s2){
        if (instancia == null){
            instancia = new LocadoraDeVeiculos(nome, endereco, website, redeSocial);
        }
        return instancia;
    }
}

