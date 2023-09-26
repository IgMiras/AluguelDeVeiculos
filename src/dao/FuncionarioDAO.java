/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import models.Funcionario;
import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alunos
 */
public class FuncionarioDAO {
    
    public void create(Funcionario func){
        Connection con = Conexao.getConexao();
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
    
}
