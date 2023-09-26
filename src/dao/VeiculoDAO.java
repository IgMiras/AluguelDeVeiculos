/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Veiculo;

/**
 *
 * @author alunos
 */
public class VeiculoDAO {
    
    public void create(Veiculo veic){
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO veiculo "
                    + "(nomeModelo,montadora,anoFabricacao,anoModelo,placa,categoria,valorFipe,valorDiaria,categoriaCNHNecessaria,alugado,taxaImpostoEstadual,taxaImpostoFederal)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, veic.getNomeModelo());
            stmt.setString(2, veic.getMontadora());
            stmt.setInt(3, veic.getAnoFabricacao());
            stmt.setInt(4, veic.getAnoModelo());
            stmt.setString(5, veic.getPlaca());
            stmt.setString(6, veic.getCategoria());
            stmt.setFloat(7, veic.getValorFipe());
            stmt.setFloat(8, veic.getValorDiaria());
            stmt.setString(9, veic.getCategoriaCNHNecessaria());
            stmt.setBoolean(10, veic.estaAlugado());
            stmt.setFloat(11, veic.getTaxaImpostoEstadual());
            stmt.setFloat(12, veic.getTaxaImpostoFederal());
            
            stmt.executeUpdate();
            
            System.out.println("Veiculo salvo com sucesso!");
        } catch (SQLException ex) {
     
            System.out.println("Erro ao salvar veiculo: "+ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
}
