/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import models.Funcionario;
import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunos
 */
public class FuncionarioDAO {
    private Conexao conexao = new Conexao();
    
    public void create(Funcionario func){
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO funcionario "
                    + "(nome,cpf,rg,dataNascimento,endereco,cep,email,salario,pis,dataAdmissao)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getCpf());
            stmt.setString(3, func.getRg());
            stmt.setDate(4, java.sql.Date.valueOf(func.getDataNasci()));
            stmt.setString(5, func.getEndereco());
            stmt.setString(6, func.getCep());
            stmt.setString(7, func.getEmail());
            stmt.setFloat(8, func.getSalario());
            stmt.setString(9, func.getPis());
            stmt.setDate(10, java.sql.Date.valueOf(func.getDataAdmissao()));
            
            stmt.executeUpdate();
            
            System.out.println("Funcionario salvo com sucesso!");
        } catch (SQLException ex) {
     
            System.out.println("Erro ao salvar funcionario: "+ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Funcionario> listarTodosFuncionarios(){
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario func = new Funcionario();
                
                func.setNome(rs.getString("nome"));
                func.setCpf(rs.getString("cpf"));
                func.setRg(rs.getString("rg"));
                func.setDataNasci(rs.getDate("dataNascimento").toLocalDate()); 
                func.setEndereco(rs.getString("endereco"));
                func.setCep(rs.getString("cep"));
                func.setEmail(rs.getString("email"));
                func.setSalario(rs.getFloat("salario"));
                func.setPis(rs.getString("pis"));
                func.setDataAdmissao(rs.getDate("dataAdmissao").toLocalDate());
                funcionarios.add(func);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return funcionarios;
    }
    
    public ArrayList<Funcionario> listarFuncionariosDoMes(){
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("""
                            WITH ranked_locacoes AS (
                                SELECT
                                    f.idfuncionario,
                                    f.nome,
                                    f.cpf,
                                    f.rg,
                                    f.dataNascimento,
                                    f.endereco,
                                    f.cep,
                                    f.email,
                                    f.salario,
                                    f.pis,
                                    f.dataAdmissao,
                                    MONTH(l.data_locacao) AS mes,
                                    COUNT(*) AS total_locacoes,
                                    DENSE_RANK() OVER (PARTITION BY MONTH(l.data_locacao) ORDER BY COUNT(*) DESC) AS ranking
                                FROM locacao l
                                INNER JOIN funcionario f ON l.idfuncionario = f.idfuncionario
                                GROUP BY f.idfuncionario, f.nome, f.cpf, f.rg, f.dataNascimento, f.endereco, f.cep, f.email, f.salario, f.pis, f.dataAdmissao, mes
                            )
                            SELECT *
                            FROM ranked_locacoes
                            WHERE ranking = 1;""");

            rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario func = new Funcionario();
                
                func.setNome(rs.getString("nome"));
                func.setCpf(rs.getString("cpf"));
                func.setRg(rs.getString("rg"));
                func.setDataNasci(rs.getDate("dataNascimento").toLocalDate()); 
                func.setEndereco(rs.getString("endereco"));
                func.setCep(rs.getString("cep"));
                func.setEmail(rs.getString("email"));
                func.setSalario(rs.getFloat("salario"));
                func.setPis(rs.getString("pis"));
                func.setDataAdmissao(rs.getDate("dataAdmissao").toLocalDate());
                funcionarios.add(func);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return funcionarios;
    }
    
}
