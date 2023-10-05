/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import models.Cliente;
import models.Funcionario;
import models.Locacao;
import models.LocadoraDeVeiculos;
import models.Seguro;
import models.Veiculo;
import models.VeiculoImportado;
import models.VeiculoNacional;

/**
 *
 * @author Windows
 */
//

public class Controlador {

    private LocadoraDeVeiculos locadora = LocadoraDeVeiculos.getInstancia("AluguelDeVeiculos",
             "R. Osvaldo Peretti, 98. Jardim das Rosas. Presidente Prudente - SP",
             "www.alugueldeveiculos.com.br",
             "Instagram: @AluguelDeVeiculos");
    
        public Controlador() {
    }

    public void addFuncionario(String nome, String cpf, String rg, String dataNasci,
                               String endereco, String cep, String email, float salario,
                               String pis, String dataAdmissao) {
        
        locadora.addFuncionario(nome, cpf, rg, dataNasci, endereco, cep, email, salario, pis, dataAdmissao);
    }

    public void addCliente(String nome, String cpf, String rg, String dataNasci,
                           String endereco, String cep, String email, String categoriaCNH,
                           String numeroCNH, String validadeCNH, boolean clienteOuro) {
        
        locadora.addCliente(nome,cpf,rg,dataNasci,endereco,cep,email,categoriaCNH,numeroCNH,validadeCNH,clienteOuro);
    }

    public boolean addLocacao(int codigoCliente, int codigoFuncionario, int codigoVeiculo, String dataLocacao,
                           String dataDevolucao, String tipoPagamento, int[] segurosContratados) {
        
        return locadora.addLocacao(codigoCliente, codigoFuncionario, codigoVeiculo, dataLocacao, dataDevolucao, tipoPagamento, segurosContratados);
    }

    public void addVeiculoNacional(String tipoVeiculo,String nomeModelo, String montadora,
                                    int anoFabricacao, int anoModelo, String placa, String categoria,
                                    float valorFipe, float valorDiaria, String categoriaCNHNecessaria,
                                    float taxaImpostoEstadual) {
        
        locadora.addVeiculoNacional(tipoVeiculo, nomeModelo, montadora, anoFabricacao, anoModelo,
                                            placa, categoria, valorFipe, valorDiaria, 
                                            categoriaCNHNecessaria, taxaImpostoEstadual);
    }
    
    public void addVeiculoImportado(String tipoVeiculo,String nomeModelo, String montadora,
                                    int anoFabricacao, int anoModelo, String placa, String categoria,
                                    float valorFipe, float valorDiaria, String categoriaCNHNecessaria,
                                    float taxaImpostoEstadual, float taxaImpostoFederal){
        
        locadora.addVeiculoImportado(tipoVeiculo, nomeModelo, montadora, anoFabricacao, anoModelo,
                                            placa, categoria, valorFipe, valorDiaria, 
                                            categoriaCNHNecessaria, taxaImpostoEstadual, taxaImpostoFederal);
    } 

    public void addSeguro(String nome, String tipo, String descricao, float valor) {
       
        locadora.addSeguro(nome,tipo,descricao,valor);
    }

    public String ListarTodosVeiculosCadastrados() {
        return locadora.ListarTodosVeiculosCadastrados();
    }

    public String ListarTodosVeiculosImportados() {
        return locadora.ListarTodosVeiculosImportados();
    }

    public String ListarTodosVeiculosNacionais() {
        return locadora.ListarTodosVeiculosNacionais();
    }

    public String ListarTodosVeiculosDisponiveis() {
        return locadora.ListarTodosVeiculosDisponiveis();
    }

    public String ListarVeiculosDisponiveisCNHEspecifica(String CNH) {
        return locadora.ListarVeiculosDisponiveisCNHEspecifica(CNH);
    }

    public String ListarTodosVeiculosAlugados() {
        return locadora.ListarTodosVeiculosAlugados();
    }

    public String ListarTodosVeiculosComAtrasoDevolucao() {
        return locadora.ListarTodosVeiculosComAtrasoDevolucao();
    }

    public String ListarClientesAlugaramVeiculoEspecifico(int codigoVeiculo) {
        return locadora.ListarClientesAlugaramVeiculoEspecifico(codigoVeiculo);
    }

    public String ListarTodosFuncionariosCadastrados() {
        return locadora.ListarTodosFuncionariosCadastrados();
    }

    public String ListarTodosClientesCadastrados() {
        return locadora.ListarTodosClientesCadastrados();
    }

    public String ListarHistoricoCliente(int codigo) {
        return locadora.ListarHistoricoCliente(codigo);
    }

    public String ListarClientesComLocacoesEmAtraso() {
        return locadora.ListarClientesComLocacoesEmAtraso();
    }

    public String ListarTodasLocacoes() {
        return locadora.ListarTodasLocacoes();
    }

    public String ListarTodasLocacoesMesEspecifico(int mes) {
        return locadora.ListarTodasLocacoesMesEspecifico(mes);
    }
    
    public float LucroTotalMesEspecifico(int mes){
        return locadora.LucroTotalMesEspecifico(mes);
    }
    
    public String ListarTodasLocacoesFinalizadas(){
        return locadora.ListarTodasLocacoesFinalizadas();
    }
    
    public String ListarTodasLocacoesNaoFinalizadas() {
        return locadora.ListarTodasLocacoesNaoFinalizadas();
    }


    public String ListarTodasLocacoesNaoFinalizadasVeiculosNacionais() {
        return locadora.ListarTodasLocacoesNaoFinalizadasVeiculosNacionais();
    }

    public String ListarTodasLocacoesNaoFinalizadasVeiculosImportados() {
        return locadora.ListarTodasLocacoesNaoFinalizadasVeiculosImportados();
    }

    public String ListarTodasLocacoesEmAtaso() {
        return locadora.ListarTodasLocacoesEmAtaso();
    }

    public String ListarTodosSeguros() {
        return locadora.ListarTodosSeguros();
    }
    
    public String ListarFuncionariosDoMes(){
        return locadora.ListarFuncionariosDoMes();
    }
    
    public ArrayList<Seguro> BuscarTodosSeguros(){
        return locadora.BuscarTodosSeguros();
    }
    
    public Veiculo BuscarVeiculoPorCodigo(int codigoVeiculo){
        return locadora.BuscarVeiculoPorCodigo(codigoVeiculo);
    }

    
    
 
}
