/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Seguro;

/**
 *
 * @author alunos
 */
public class SeguroDAO {
    
    public static void create(Seguro seg){
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO seguro "
                    + "(nome,tipo,descricao,valor)"
                    + "VALUES(?,?,?,?)");
            stmt.setString(1, seg.getNome());
            stmt.setString(2, seg.getTipo());
            stmt.setString(3, seg.getDescricao());
            stmt.setFloat(4, seg.getValor());
            
            stmt.executeUpdate();
            
            System.out.println("Seguro salvo com sucesso!");
        } catch (SQLException ex) {
     
            System.out.println("Erro ao salvar Seguro: "+ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
}
