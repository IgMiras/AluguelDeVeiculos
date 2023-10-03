/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Seguro;

/**
 *
 * @author alunos
 */
public class SeguroDAO {
    private Conexao conexao = new Conexao();
    
    public void create(Seguro seg){
        Connection con = conexao.getConexao();
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
    
    public ArrayList<Seguro> listarTodosSeguros() {
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Seguro> seguros = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM seguro");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Seguro seg = new Seguro();
                
                seg.setNome(rs.getString("nome"));
                seg.setCodigoSeguro(rs.getInt("idseguro"));
                seg.setNome(rs.getString("nome"));
                seg.setTipo(rs.getString("tipo"));
                seg.setDescricao(rs.getString("descricao"));
                seg.setValor(rs.getFloat("valor"));
                
                seguros.add(seg);
            }
        } catch (SQLException ex) {
             Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return seguros;
    }
    
}
