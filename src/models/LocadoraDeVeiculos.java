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
    
    public String listarTodosVeiculos(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        String relatorio = "";
        for (Veiculo veic : veicDAO.listarTodosVeiculos()){
            if(veic instanceof VeiculoNacional){
                VeiculoNacional vn = (VeiculoNacional) veic;
                relatorio = relatorio + vn.toString();
            } else {
                VeiculoImportado vi = (VeiculoImportado) veic;
                relatorio = relatorio + vi.toString();
            }
        }
        return relatorio;
    }
    
    public String listarTodosVeiculosNacionais(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        String relatorio = "";
        for (Veiculo veic: veicDAO.listarTodosVeiculosNacionais()){
            VeiculoNacional vn = (VeiculoNacional) veic;
            relatorio = relatorio + vn.toString();
        }
        return relatorio;
    }

    public String listarTodosVeiculosImportados(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        String relatorio = "";
        for (Veiculo veic: veicDAO.listarTodosVeiculosImportados()){
            VeiculoImportado vi = (VeiculoImportado) veic;
            relatorio = relatorio + vi.toString();
        }
        return relatorio;
    }
    
    public String listarTodosVeiculosDisponiveis(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        String relatorio = "";
        for (Veiculo veic : veicDAO.listarTodosVeiculosDisponiveis()){
            if(veic instanceof VeiculoNacional){
                VeiculoNacional vn = (VeiculoNacional) veic;
                relatorio = relatorio + vn.toString();
            } else {
                VeiculoImportado vi = (VeiculoImportado) veic;
                relatorio = relatorio + vi.toString();
            }
        }
        return relatorio;
    }
    
    public String listarVeiculosDisponiveisCNHEspecifica(String categoriaCNH) {
        VeiculoDAO veicDAO = new VeiculoDAO();
        String relatorio = "";
        for (Veiculo veic : veicDAO.listarVeiculosDisponiveisCNHEspecifica(categoriaCNH)){
            if(veic instanceof VeiculoNacional){
                VeiculoNacional vn = (VeiculoNacional) veic;
                relatorio = relatorio + vn.toString();
            } else {
                VeiculoImportado vi = (VeiculoImportado) veic;
                relatorio = relatorio + vi.toString();
            }
        }
        return relatorio;
    }
    
    public String listarTodosVeiculosAlugados(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        String relatorio = "";
        for (Veiculo veic : veicDAO.listarTodosVeiculosAlugados()){
            if(veic instanceof VeiculoNacional){
                VeiculoNacional vn = (VeiculoNacional) veic;
                relatorio = relatorio + vn.toString();
            } else {
                VeiculoImportado vi = (VeiculoImportado) veic;
                relatorio = relatorio + vi.toString();
            }
        }
        return relatorio;
    }
    
    public String listarTodosVeiculosComAtrasoDevolucao(){
        VeiculoDAO veicDAO = new VeiculoDAO();
        String relatorio = "";
        for (Veiculo veic : veicDAO.listarTodosVeiculosAlugados()){
            if(veic instanceof VeiculoNacional){
                VeiculoNacional vn = (VeiculoNacional) veic;
                relatorio = relatorio + vn.toString();
            } else {
                VeiculoImportado vi = (VeiculoImportado) veic;
                relatorio = relatorio + vi.toString();
            }
        }
        return relatorio;
    }
    
    public String listarClientesAlugaramVeiculoEspecifico(int codigoVeiculo) {
        ClienteDAO clienteDAO = new ClienteDAO();
        String relatorio = "";
        for (Cliente cliente : clienteDAO.listarClientesAlugaramVeiculoEspecifico(codigoVeiculo)){
            relatorio = relatorio + cliente.toString();
        }
        return relatorio;
    }
    
    public String listarTodosFuncionarios(){
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        String relatorio = "";
        for (Funcionario func : funcDAO.listarTodosFuncionarios()){
            relatorio = relatorio + func.toString();
        }
        return relatorio;
    }
    
    public String listarFuncionariosDoMes(){
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        String relatorio = "";
        for (Funcionario func : funcDAO.listarFuncionariosDoMes()){
            relatorio = relatorio + func.toString();
        }
        return relatorio;
    }
    
    public String listarTodosClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        String relatorio = "";
        for (Cliente cliente : clienteDAO.listarTodosClientes()){
            relatorio = relatorio + cliente.toString();
        }
        return relatorio;
    }
    
    public String listarTodasLocacoesClienteEspecifico(int codigoCliente) {
        LocacaoDAO locDAO = new LocacaoDAO();
        String relatorio = "";
        for (Locacao loc : locDAO.listarTodasLocacoesClienteEspecifico(codigoCliente)){
            relatorio = relatorio + loc.toString();
        }
        return relatorio;
    }
    
    public String listarClientesLocacaoAtraso() {
        ClienteDAO clienteDAO = new ClienteDAO();
        String relatorio = "";
        for (Cliente cliente : clienteDAO.listarClientesLocacaoAtraso()){
            relatorio = relatorio + cliente.toString();
        }
        return relatorio;
    }   
    
    public String listarTodasLocacoes() {
        LocacaoDAO locDAO = new LocacaoDAO();
        String relatorio = "";
        for (Locacao loc : locDAO.listarTodasLocacoes()){
            relatorio = relatorio + loc.toString();
        }
        return relatorio;
    }
    
    public String listarTodasLocacoesMesEspecifico(int mes) {
        LocacaoDAO locDAO = new LocacaoDAO();
        String relatorio = "";
        for (Locacao loc : locDAO.listarTodasLocacoesMesEspecifico(mes)){
            relatorio = relatorio + loc.toString();
        }
        return relatorio;
    }
    
    public String lucroTotalMesEspecifico(int mes) {
        LocacaoDAO locDAO = new LocacaoDAO();
        String relatorio = "";
        for (Locacao loc : locDAO.lucroTotalMesEspecifico(mes)){
            relatorio = relatorio + loc.toString();
        }
        return relatorio;
    }
    
    public String listarTodasLocacoesFinalizadas() {
        LocacaoDAO locDAO = new LocacaoDAO();
        String relatorio = "";
        for (Locacao loc : locDAO.listarTodasLocacoesFinalizadas()){
            relatorio = relatorio + loc.toString();
        }
        return relatorio;
    }
    
    public String listarTodasLocacoesNaoFinalizadas() {
        LocacaoDAO locDAO = new LocacaoDAO();
        String relatorio = "";
        for (Locacao loc : locDAO.listarTodasLocacoesNaoFinalizadas()){
            relatorio = relatorio + loc.toString();
        }
        return relatorio;
    }
    
    public String listarTodasLocacoesNaoFinalizadasVeiculosNacionais() {
        LocacaoDAO locDAO = new LocacaoDAO();
        String relatorio = "";
        for (Locacao loc : locDAO.listarTodasLocacoesNaoFinalizadasVeiculosNacionais()){
            relatorio = relatorio + loc.toString();
        }
        return relatorio;
    }
    
    public String listarTodasLocacoesNaoFinalizadasVeiculosImportados() {
        LocacaoDAO locDAO = new LocacaoDAO();
        String relatorio = "";
        for (Locacao loc : locDAO.listarTodasLocacoesNaoFinalizadasVeiculosImportados()){
            relatorio = relatorio + loc.toString();
        }
        return relatorio;
    }
    
    public String listarTodasLocacoesEmAtaso() {
        LocacaoDAO locDAO = new LocacaoDAO();
        String relatorio = "";
        for (Locacao loc : locDAO.listarTodasLocacoesEmAtraso()){
            relatorio = relatorio + loc.toString();
        }
        return relatorio;
    }
    
    public String listarTodosSeguros() {
        SeguroDAO segDAO = new SeguroDAO();
        String relatorio = "";
        for (Seguro seg : segDAO.listarTodosSeguros()){
            relatorio = relatorio + seg.toString();
        }
        return relatorio;
    }
    
    
    
}

