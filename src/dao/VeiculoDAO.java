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
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Veiculo;
import models.VeiculoImportado;

/**
 *
 * @author alunos
 */
public class VeiculoDAO {
    
    public static void create(Veiculo veic){
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
    
    public ArrayList<Veiculo> listarTodosVeiculos(){
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM veiculo");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Veiculo veic = new VeiculoImportado();
                
                veic.setCodigoVeiculo(rs.getInt("idveiculo"));
                veic.setNomeModelo(rs.getString("nomeModelo"));
                veic.setMontadora(rs.getString("montadora"));
                veic.setAnoFabricacao(rs.getInt("anoFabricacao"));
                veic.setAnoModelo(rs.getInt("anoModelo"));
                veic.setPlaca(rs.getString("placa"));
                veic.setCategoria(rs.getString("categoria"));
                veic.setValorFipe(rs.getFloat("valorFipe"));
                veic.setValorDiaria(rs.getFloat("valorDiaria"));
                veic.setCategoriaCNHNecessaria(rs.getString("categoriaCNHNecessaria"));
                veic.setAlugado(rs.getBoolean("alugado"));
                veic.setTaxaImpostoEstadual(rs.getFloat("taxaImpostoEstadual"));
                veic.setTaxaImpostoFederal(rs.getFloat("taxaImpostoFederal"));
                veiculos.add(veic);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return veiculos;
    }
    
}
