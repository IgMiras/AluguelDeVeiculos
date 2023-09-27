/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import java.time.LocalDate;
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
    
    public void addCliente(String nome, String cpf, String rg, String dataNasci,
                           String endereco, String cep, String email, String categoriaCNH,
                           String numeroCNH, String validadeCNH, boolean clienteOuro){
        
        Cliente cliente = new Cliente(nome,cpf,rg,dataNasci,endereco,cep,email,categoriaCNH,numeroCNH,validadeCNH,clienteOuro);
        ClienteDAO.create(cliente);
    }
    
    public void addFuncionario(String nome, String cpf, String rg, String dataNasci,
                               String endereco, String cep, String email, float salario,
                               String pis, String dataAdmissao){
        
        Funcionario func = new Funcionario(nome,cpf,rg,dataNasci,endereco,cep,email,salario,pis,dataAdmissao);
        FuncionarioDAO.create(func);
    }
    
    public void addVeiculo(float taxaImpostoEstadual, float taxaImpostoFederal, 
                           int codigoVeiculo, String nomeModelo, String montadora,
                           int anoFabricacao, int anoModelo, String placa, String categoria,
                           float valorFipe, float valorDiaria, String categoriaCNHNecessaria) {
        
                        // Instanciando sempre um VeiculoImportado, tanto para nacional quanto importado
                        // Quando instanciar um Nacional, 
        Veiculo veic = new VeiculoImportado(nomeModelo, montadora, anoFabricacao, anoModelo,
                                            placa, categoria, valorFipe, valorDiaria, 
                                            categoriaCNHNecessaria, taxaImpostoEstadual, taxaImpostoFederal);
        ClienteDAO.create(cliente);
    }
    
    public void addCliente(String nome, String cpf, String rg, String dataNasci,
                           String endereco, String cep, String email, String categoriaCNH,
                           String numeroCNH, String validadeCNH, boolean clienteOuro){
        Cliente cliente = new Cliente(nome,cpf,rg,dataNasci,endereco,cep,email,categoriaCNH,numeroCNH,validadeCNH,clienteOuro);
        ClienteDAO.create(cliente);
    }
    
    public void addCliente(String nome, String cpf, String rg, String dataNasci,
                           String endereco, String cep, String email, String categoriaCNH,
                           String numeroCNH, String validadeCNH, boolean clienteOuro){
        Cliente cliente = new Cliente(nome,cpf,rg,dataNasci,endereco,cep,email,categoriaCNH,numeroCNH,validadeCNH,clienteOuro);
        ClienteDAO.create(cliente);
    }

    public static LocadoraDeVeiculos getInstancia(String nome, String endereco, String website, String redeSocial){
        if (instancia == null){
            instancia = new LocadoraDeVeiculos(nome, endereco, website, redeSocial);
        }
        return instancia;
    }
}

