/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.LocacaoDAO;
import dao.SeguroDAO;
import dao.VeiculoDAO;
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
    
    public static LocadoraDeVeiculos getInstancia(String nome, String endereco, String website, String redeSocial){
        if (instancia == null){
            instancia = new LocadoraDeVeiculos(nome, endereco, website, redeSocial);
        }
        return instancia;
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
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.create(cliente);
    }
    
    public void addFuncionario(String nome, String cpf, String rg, String dataNasci,
                               String endereco, String cep, String email, float salario,
                               String pis, String dataAdmissao){
        
        Funcionario func = new Funcionario(nome,cpf,rg,dataNasci,endereco,cep,email,salario,pis,dataAdmissao);
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        funcDAO.create(func);
    }
    
    public void addVeiculoImportado(String tipoVeiculo,String nomeModelo, String montadora,
                                    int anoFabricacao, int anoModelo, String placa, String categoria,
                                    float valorFipe, float valorDiaria, String categoriaCNHNecessaria,
                                    float taxaImpostoEstadual, float taxaImpostoFederal) {
        
                         
        Veiculo veic = new VeiculoImportado(tipoVeiculo, nomeModelo, montadora, anoFabricacao, anoModelo,
                                            placa, categoria, valorFipe, valorDiaria, 
                                            categoriaCNHNecessaria, taxaImpostoEstadual, taxaImpostoFederal);
        VeiculoDAO veicDAO = new VeiculoDAO();
        veicDAO.create(veic);
    }
    
    public void addVeiculoNacional(String tipoVeiculo,String nomeModelo, String montadora,
                                    int anoFabricacao, int anoModelo, String placa, String categoria,
                                    float valorFipe, float valorDiaria, String categoriaCNHNecessaria,
                                    float taxaImpostoEstadual) {
        
                         
        Veiculo veic = new VeiculoNacional(tipoVeiculo, nomeModelo, montadora, anoFabricacao, anoModelo,
                                            placa, categoria, valorFipe, valorDiaria, 
                                            categoriaCNHNecessaria, taxaImpostoEstadual);
        VeiculoDAO veicDAO = new VeiculoDAO();
        veicDAO.create(veic);
    }
    
    public void addSeguro(String nome, String tipo, String descricao, float valor){
        
        Seguro seguro = new Seguro(nome,tipo,descricao,valor);
        SeguroDAO segDAO = new SeguroDAO();
        segDAO.create(seguro);
    }
    
    public void addLocacao(int codigoCliente, int codigoFuncionario, int codigoVeiculo, String dataLocacao,
                           String dataDevolucao, float valorTotal, String tipoPagamento, ArrayList<Seguro> segurosContratados){
        
        VeiculoDAO veicDAO = new VeiculoDAO();
        Veiculo veic = veicDAO.buscarVeiculo(codigoVeiculo);
        
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarClientePorID(codigoCliente);
        
        if (cliente.getCategoriaCNH().equalsIgnoreCase(veic.getCategoriaCNHNecessaria())){
            Locacao loc = new Locacao(codigoCliente, codigoFuncionario, veic, dataLocacao, dataDevolucao, valorTotal, tipoPagamento, segurosContratados);
            LocacaoDAO locDAO = new LocacaoDAO();
            locDAO.create(loc);
            return;
        }
        System.out.println("Cliente nao possui Categoria CNH necessaria");
    }
    
    public ArrayList<Veiculo> listarTodosVeiculos(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        return veicDAO.listarTodosVeiculos();
    }
    
    public ArrayList<Veiculo> listarTodosVeiculosNacionais(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        return veicDAO.listarTodosVeiculosNacionais();
    }

    public ArrayList<Veiculo> listarTodosVeiculosImportados(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        return veicDAO.listarTodosVeiculosImportados();
    }
    
    public ArrayList<Veiculo> listarTodosVeiculosDisponiveis(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        return veicDAO.listarTodosVeiculosDisponiveis();
    }
    
    public ArrayList<Veiculo> listarVeiculosDisponiveisCNHEspecifica(String categoriaCNH) {
        VeiculoDAO veicDAO = new VeiculoDAO();
        return veicDAO.listarVeiculosDisponiveisCNHEspecifica(categoriaCNH);
    }
    
    public ArrayList<Veiculo> listarTodosVeiculosAlugados(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        return veicDAO.listarTodosVeiculosAlugados();
    }
    
    public ArrayList<Veiculo> listarTodosVeiculosComAtrasoDevolucao(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        return veicDAO.listarTodosVeiculosComAtrasoDevolucao();
    }
    
    public ArrayList<Cliente> listarClientesAlugaramVeiculoEspecifico(int codigoVeiculo) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.listarClientesAlugaramVeiculoEspecifico(codigoVeiculo);
    }
    
    public ArrayList<Funcionario> listarTodosFuncionarios(){
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        return funcDAO.listarTodosFuncionarios();
    }
    
    public ArrayList<Funcionario> listarFuncionariosDoMes(){
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        return funcDAO.listarFuncionariosDoMes();
    }
    
    public ArrayList<Cliente> listarTodosClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.listarTodosClientes();
    }
    
    public ArrayList<Locacao> listarTodasLocacoesClienteEspecifico(int codigoCliente) {
        LocacaoDAO locDAO = new LocacaoDAO();
        return locDAO.listarTodasLocacoesClienteEspecifico(codigoCliente);
    }
    
    public ArrayList<Cliente> listarClientesLocacaoAtraso() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.listarClientesLocacaoAtraso();
    }   
    
    public ArrayList<Locacao> listarTodasLocacoes() {
        LocacaoDAO locDAO = new LocacaoDAO();
        return locDAO.listarTodasLocacoes();
    }
    
    public ArrayList<Locacao> listarTodasLocacoesMesEspecifico(int mes) {
        LocacaoDAO locDAO = new LocacaoDAO();
        return locDAO.listarTodasLocacoesMesEspecifico(mes);
    }
    
    public ArrayList<Locacao> lucroTotalMesEspecifico(int mes) {
        LocacaoDAO locDAO = new LocacaoDAO();
        return locDAO.lucroTotalMesEspecifico(mes);
    }
    
    public ArrayList<Locacao> listarTodasLocacoesFinalizadas() {
        LocacaoDAO locDAO = new LocacaoDAO();
        return locDAO.listarTodasLocacoesFinalizadas();
    }
    
    public ArrayList<Locacao> listarTodasLocacoesNaoFinalizadas() {
        LocacaoDAO locDAO = new LocacaoDAO();
        return locDAO.listarTodasLocacoesNaoFinalizadas();
    }
    
    public ArrayList<Locacao> listarTodasLocacoesNaoFinalizadasVeiculosNacionais() {
        LocacaoDAO locDAO = new LocacaoDAO();
        return locDAO.listarTodasLocacoesNaoFinalizadasVeiculosNacionais();
    }
    
    public ArrayList<Locacao> listarTodasLocacoesNaoFinalizadasVeiculosImportados() {
        LocacaoDAO locDAO = new LocacaoDAO();
        return locDAO.listarTodasLocacoesNaoFinalizadasVeiculosImportados();
    }
    
    public ArrayList<Locacao> listarTodasLocacoesEmAtaso() {
        LocacaoDAO locDAO = new LocacaoDAO();
        return locDAO.listarTodasLocacoesEmAtraso();
    }
    
    public ArrayList<Seguro> listarTodosSeguros() {
        SeguroDAO segDAO = new SeguroDAO();
        return segDAO.listarTodosSeguros();
    }
    
    
    
}

