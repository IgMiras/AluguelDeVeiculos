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
import models.VeiculoNacional;

/**
 *
 * @author alunos
 */
public class VeiculoDAO {
    private Conexao conexao = new Conexao();
    
    public void create(Veiculo veic){
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO veiculo "
                    + "(tipoVeiculo,nomeModelo,montadora,anoFabricacao,anoModelo,placa,categoria,valorFipe,valorDiaria,categoriaCNHNecessaria,alugado,taxaImpostoEstadual,taxaImpostoFederal)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            if (veic.getTipoVeiculo().toLowerCase().contains("nacional")){
                VeiculoNacional vn = (VeiculoNacional) veic;
                stmt.setString(1, vn.getTipoVeiculo());
                stmt.setString(2, vn.getNomeModelo());
                stmt.setString(3, vn.getMontadora());
                stmt.setInt(4, vn.getAnoFabricacao());
                stmt.setInt(5, vn.getAnoModelo());
                stmt.setString(6, vn.getPlaca());
                stmt.setString(7, vn.getCategoria());
                stmt.setFloat(8, vn.getValorFipe());
                stmt.setFloat(9, vn.getValorDiaria());
                stmt.setString(10, vn.getCategoriaCNHNecessaria());
                stmt.setBoolean(11, vn.estaAlugado());
                stmt.setFloat(12, vn.getTaxaImpostoEstadual());
                stmt.setFloat(13, 0);
            } else {
                VeiculoImportado vi = (VeiculoImportado) veic;
                stmt.setString(1, vi.getTipoVeiculo());
                stmt.setString(2, vi.getNomeModelo());
                stmt.setString(3, vi.getMontadora());
                stmt.setInt(4, vi.getAnoFabricacao());
                stmt.setInt(5, vi.getAnoModelo());
                stmt.setString(6, vi.getPlaca());
                stmt.setString(7, vi.getCategoria());
                stmt.setFloat(8, vi.getValorFipe());
                stmt.setFloat(9, vi.getValorDiaria());
                stmt.setString(10, vi.getCategoriaCNHNecessaria());
                stmt.setBoolean(11, vi.estaAlugado());
                stmt.setFloat(12, vi.getTaxaImpostoEstadual());
                stmt.setFloat(13, vi.getTaxaImpostoFederal());
            }
            
            stmt.executeUpdate();
            
            System.out.println("Veiculo salvo com sucesso!");
        } catch (SQLException ex) {
     
            System.out.println("Erro ao salvar veiculo: "+ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Veiculo> listarTodosVeiculos(){
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM veiculo");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                if (rs.getString("tipoVeiculo").toLowerCase().contains("nacional")){
                    Veiculo veic = new VeiculoNacional();
                
                    veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
                    veiculos.add(veic);
                }
                if (rs.getString("tipoVeiculo").toLowerCase().contains("importado")){
                    Veiculo veic = new VeiculoImportado();
                
                    veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return veiculos;
    }
    
    public ArrayList<Veiculo> listarTodosVeiculosNacionais(){
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM veiculo WHERE tipoVeiculo='nacional'"); //LEMBRAR DE SALVAR tipoVeiculo='nacional' (DESSE JEITO!)
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Veiculo veic = new VeiculoNacional();
                
                veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
                veiculos.add(veic);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return veiculos;
    }
    
    public ArrayList<Veiculo> listarTodosVeiculosImportados(){
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM veiculo WHERE tipoVeiculo='importado'"); //LEMBRAR DE SALVAR tipoVeiculo='importado' (DESSE JEITO!)
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Veiculo veic = new VeiculoImportado();
                
                veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
    
    public ArrayList<Veiculo> listarTodosVeiculosDisponiveis(){
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM veiculo WHERE alugado=0"); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
                if (rs.getString("tipoVeiculo").toLowerCase().contains("nacional")){
                    Veiculo veic = new VeiculoNacional();
                
                    veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
                    veiculos.add(veic);
                }
                if (rs.getString("tipoVeiculo").toLowerCase().contains("importado")){
                    Veiculo veic = new VeiculoImportado();
                
                    veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return veiculos;
    }
    
    public ArrayList<Veiculo> listarVeiculosDisponiveisCNHEspecifica(String categoriaCNH) {
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Veiculo> veiculos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM veiculo WHERE categoriaCNHNecessaria = ? AND alugado = 0");
            stmt.setString(1, categoriaCNH);
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                if (rs.getString("tipoVeiculo").toLowerCase().contains("nacional")){
                    Veiculo veic = new VeiculoNacional();
                
                    veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
                    veiculos.add(veic);
                }
                
                if (rs.getString("tipoVeiculo").toLowerCase().contains("importado")){
                    Veiculo veic = new VeiculoImportado();
                
                    veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
                
            }
        } catch (SQLException ex) {
             Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return veiculos;
    }
    
    public ArrayList<Veiculo> listarTodosVeiculosAlugados(){
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM veiculo WHERE alugado=1"); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
                if (rs.getString("tipoVeiculo").toLowerCase().contains("nacional")){
                    Veiculo veic = new VeiculoNacional();
                
                    veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
                    veiculos.add(veic);
                }
                if (rs.getString("tipoVeiculo").toLowerCase().contains("importado")){
                    Veiculo veic = new VeiculoImportado();
                
                    veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return veiculos;
    }
    
    public ArrayList<Veiculo> listarTodosVeiculosComAtrasoDevolucao(){
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("""
                                        SELECT v.*
                                        FROM veiculo v
                                        JOIN locacao l ON v.idveiculo = l.idveiculo
                                        WHERE l.data_devolucao < CURRENT_DATE() AND l.finalizada = 0;"""); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
                if (rs.getString("tipoVeiculo").toLowerCase().contains("nacional")){
                    Veiculo veic = new VeiculoNacional();
                
                    veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
                    veiculos.add(veic);
                }
                if (rs.getString("tipoVeiculo").toLowerCase().contains("importado")){
                    Veiculo veic = new VeiculoImportado();
                
                    veic.setTipoVeiculo(rs.getString("tipoVeiculo"));
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return veiculos;
    }
    
    public Veiculo buscarVeiculo(int codigoVeiculo){
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM veiculo WHERE idveiculo = ?");
            stmt.setInt(1,codigoVeiculo);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                if (rs.getString("tipoVeiculo").toLowerCase().contains("nacional")) {
                    Veiculo vn = new VeiculoNacional();
                    vn = (VeiculoNacional) vn;

                    vn.setTipoVeiculo(rs.getString("tipoVeiculo"));
                    vn.setCodigoVeiculo(rs.getInt("idveiculo"));
                    vn.setNomeModelo(rs.getString("nomeModelo"));
                    vn.setMontadora(rs.getString("montadora"));
                    vn.setAnoFabricacao(rs.getInt("anoFabricacao"));
                    vn.setAnoModelo(rs.getInt("anoModelo"));
                    vn.setPlaca(rs.getString("placa"));
                    vn.setCategoria(rs.getString("categoria"));
                    vn.setValorFipe(rs.getFloat("valorFipe"));
                    vn.setValorDiaria(rs.getFloat("valorDiaria"));
                    vn.setCategoriaCNHNecessaria(rs.getString("categoriaCNHNecessaria"));
                    vn.setAlugado(rs.getBoolean("alugado"));
                    vn.setTaxaImpostoEstadual(rs.getFloat("taxaImpostoEstadual"));
                    
                    Conexao.closeConnection(con, stmt, rs);
                    return vn;

                } else {

                    Veiculo vi = new VeiculoImportado();
                    vi = (VeiculoImportado) vi;

                    vi.setTipoVeiculo(rs.getString("tipoVeiculo"));
                    vi.setCodigoVeiculo(rs.getInt("idveiculo"));
                    vi.setNomeModelo(rs.getString("nomeModelo"));
                    vi.setMontadora(rs.getString("montadora"));
                    vi.setAnoFabricacao(rs.getInt("anoFabricacao"));
                    vi.setAnoModelo(rs.getInt("anoModelo"));
                    vi.setPlaca(rs.getString("placa"));
                    vi.setCategoria(rs.getString("categoria"));
                    vi.setValorFipe(rs.getFloat("valorFipe"));
                    vi.setValorDiaria(rs.getFloat("valorDiaria"));
                    vi.setCategoriaCNHNecessaria(rs.getString("categoriaCNHNecessaria"));
                    vi.setAlugado(rs.getBoolean("alugado"));
                    vi.setTaxaImpostoEstadual(rs.getFloat("taxaImpostoEstadual"));
                    vi.setTaxaImpostoFederal(rs.getFloat("taxaImpostoFederal"));
                    
                    Conexao.closeConnection(con, stmt, rs);
                    return vi;
                }
                
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return null;
    }
    
}
