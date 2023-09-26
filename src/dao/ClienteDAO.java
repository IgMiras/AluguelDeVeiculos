/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cliente;

/**
 *
 * @author alunos
 */
public class ClienteDAO {
    
    public void create(Cliente cliente){
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente "
                    + "(nome,cpf,rg,dataNascimento,endereco,cep,email,categoriaCNH,numeroCNH,validadeCNH,clienteOuro)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setDate(4, java.sql.Date.valueOf(cliente.getDataNasci()));
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getCep());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getCategoriaCNH());
            stmt.setString(9, cliente.getNumeroCNH());
            stmt.setDate(10, java.sql.Date.valueOf(cliente.getValidadeCNH()));
            stmt.setBoolean(11, cliente.isClienteOuro());
            
            stmt.executeUpdate();
            
            System.out.println("Cliente salvo com sucesso!");
        } catch (SQLException ex) {
     
            System.out.println("Erro ao salvar cliente: "+ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}
