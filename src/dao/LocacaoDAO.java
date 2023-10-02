/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexao;
import java.lang.System.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import models.Locacao;
import java.util.ArrayList;
import models.Seguro;
import models.Veiculo;
import models.VeiculoImportado;
import models.VeiculoNacional;

/**
 *
 * @author alunos
 */
public class LocacaoDAO {
    
    public static void create(Locacao loc){
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            // Atualizar campos para LOCACAO
            stmt = con.prepareStatement("INSERT INTO locacao "
                    + "(idcliente,idfuncionario,idveiculo,data_locacao,data_devolucao,valor_total,tipo_pagamento,finalizada)"
                    + "VALUES(?,?,?,?,?,?,?,?)");
            stmt.setInt(1, loc.getCodigoCliente());
            stmt.setInt(2, loc.getCodigoFuncionario());
            stmt.setInt(3, loc.getCodigoVeiculo());
            stmt.setDate(4, java.sql.Date.valueOf(loc.getDataLocacao()));
            stmt.setDate(5, java.sql.Date.valueOf(loc.getDataDevolucao()));
            stmt.setFloat(6, loc.getValorTotal());
            stmt.setString(7, loc.getTipoPagamento());
            stmt.setBoolean(8, loc.estaFinalizada());
            
            stmt.executeUpdate();
            
            // Obter o ID da locação inserida
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            
            // Se tiver next(), quer dizer que a operação de inserção foi bem sucedida
            if (generatedKeys.next()) {
                int idLocacaoInserida = generatedKeys.getInt(1);
                stmt = con.prepareStatement("INSERT INTO locacao_seguro "
                        + "(idlocacao, idseguro)"
                        + "VALUES(?, ?)");
                for (Seguro seguro : loc.getSegurosContratados()){
                    stmt.setInt(1, idLocacaoInserida);
                    stmt.setInt(2, seguro.getCodigoSeguro());
                    stmt.executeUpdate();
                }
            } else {
                throw new SQLException("Falha ao obter o ID da locação inserida.");
            }
            
            System.out.println("Funcionario salvo com sucesso!");
        } catch (SQLException ex) {
     
            System.out.println("Erro ao salvar funcionario: "+ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Locacao> listarTodasLocacoesClienteEspecifico(int codigoCliente) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Locacao> locacoes = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("""
                                        SELECT
                                            locacao.idlocacao,
                                            veiculo.*,
                                            locacao.data_locacao,
                                            locacao.data_devolucao,
                                            locacao.valor_total,
                                            locacao.tipo_pagamento,
                                            locacao.finalizada,
                                            locacao.idfuncionario
                                        FROM
                                            locacao
                                        JOIN
                                            veiculo ON locacao.idveiculo = veiculo.idveiculo
                                        WHERE
                                            locacao.idcliente = ?""");
            stmt.setInt(1,codigoCliente);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Locacao loc = new Locacao();
                loc.setCodigoLocacao(rs.getInt("idlocacao"));
                loc.setCodigoCliente(rs.getInt("idcliente"));
                loc.setCodigoFuncionario(rs.getInt("idfuncionario"));
                
                Veiculo veic;
                if (rs.getString("tipoVeiculo").toLowerCase().contains("nacional")){
                    veic = new VeiculoNacional();
                
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
                } else {
                    veic = new VeiculoImportado();
                
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
                }
                
                loc.setVeiculo(veic);
                loc.setDataLocacao(rs.getDate("data_locacao").toLocalDate());
                loc.setDataDevolucao(rs.getDate("data_devolucao").toLocalDate());
                loc.setTipoPagamento(rs.getString("tipo_pagamento"));
                loc.setFinalizada(rs.getBoolean("finalizada"));
                
                
                stmt = con.prepareStatement("""
                                            SELECT seguro.*
                                            FROM locacao_seguro
                                            JOIN seguro ON locacao_seguro.idseguro = seguro.idseguro
                                            WHERE locacao_seguro.idlocacao = ?""");
                stmt.setInt(1, rs.getInt("idlocacao"));
                rs = stmt.executeQuery();
                
                ArrayList<Seguro> seguros = new ArrayList<>();
                while (rs.next()){
                    Seguro seg = new Seguro();
                    seg.setCodigoSeguro(rs.getInt("idseguro"));
                    seg.setNome(rs.getString("nome"));
                    seg.setTipo(rs.getString("tipo"));
                    seg.setDescricao(rs.getString("descricao"));
                    seg.setValor(rs.getFloat("valor"));
                    seguros.add(seg);
                }    
                
                loc.setSegurosContratados(seguros);
                loc.setValorTotal(rs.getFloat("valor_total"));
                
                locacoes.add(loc);
            }    
            
        } catch (SQLException ex) {
             System.out.println("ERRO NA BUSCA!");
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return locacoes;
    
    }
    
    public ArrayList<Locacao> listarTodasLocacoes() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Locacao> locacoes = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("""
                                        SELECT
                                            locacao.idlocacao,
                                            locacao.idcliente,
                                            veiculo.*,
                                            locacao.data_locacao,
                                            locacao.data_devolucao,
                                            locacao.valor_total,
                                            locacao.tipo_pagamento,
                                            locacao.finalizada,
                                            locacao.idfuncionario
                                        FROM
                                            locacao
                                        JOIN
                                            veiculo ON locacao.idveiculo = veiculo.idveiculo""");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Locacao loc = new Locacao();
                loc.setCodigoLocacao(rs.getInt("idlocacao"));
                loc.setCodigoCliente(rs.getInt("idcliente"));
                loc.setCodigoFuncionario(rs.getInt("idfuncionario"));
                
                Veiculo veic;
                if (rs.getString("tipoVeiculo").toLowerCase().contains("nacional")){
                    veic = new VeiculoNacional();
                
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
                } else {
                    veic = new VeiculoImportado();
                
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
                }
                
                loc.setVeiculo(veic);
                loc.setDataLocacao(rs.getDate("data_locacao").toLocalDate());
                loc.setDataDevolucao(rs.getDate("data_devolucao").toLocalDate());
                loc.setTipoPagamento(rs.getString("tipo_pagamento"));
                loc.setFinalizada(rs.getBoolean("finalizada"));
                
                
                stmt = con.prepareStatement("""
                                            SELECT seguro.*
                                            FROM locacao_seguro
                                            JOIN seguro ON locacao_seguro.idseguro = seguro.idseguro
                                            WHERE locacao_seguro.idlocacao = ?""");
                stmt.setInt(1, rs.getInt("idlocacao"));
                rs = stmt.executeQuery();
                
                ArrayList<Seguro> seguros = new ArrayList<>();
                while (rs.next()){
                    Seguro seg = new Seguro();
                    seg.setCodigoSeguro(rs.getInt("idseguro"));
                    seg.setNome(rs.getString("nome"));
                    seg.setTipo(rs.getString("tipo"));
                    seg.setDescricao(rs.getString("descricao"));
                    seg.setValor(rs.getFloat("valor"));
                    seguros.add(seg);
                }    
                
                loc.setSegurosContratados(seguros);
                loc.setValorTotal(rs.getFloat("valor_total"));
                
                locacoes.add(loc);
            }    
            
        } catch (SQLException ex) {
             System.out.println("ERRO NA BUSCA!");
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return locacoes;
    
    }
    
    public ArrayList<Locacao> listarTodasLocacoesMesEspecifico(int mes) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Locacao> locacoes = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("""
                                        SELECT
                                            *
                                        FROM
                                            locacao
                                        WHERE
                                            MONTH(data_locacao) = ?""");
            stmt.setInt(1, mes);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Locacao loc = new Locacao();
                loc.setCodigoLocacao(rs.getInt("idlocacao"));
                loc.setCodigoCliente(rs.getInt("idcliente"));
                loc.setCodigoFuncionario(rs.getInt("idfuncionario"));
                
                Veiculo veic;
                if (rs.getString("tipoVeiculo").toLowerCase().contains("nacional")){
                    veic = new VeiculoNacional();
                
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
                } else {
                    veic = new VeiculoImportado();
                
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
                }
                
                loc.setVeiculo(veic);
                loc.setDataLocacao(rs.getDate("data_locacao").toLocalDate());
                loc.setDataDevolucao(rs.getDate("data_devolucao").toLocalDate());
                loc.setTipoPagamento(rs.getString("tipo_pagamento"));
                loc.setFinalizada(rs.getBoolean("finalizada"));
                
                
                stmt = con.prepareStatement("""
                                            SELECT seguro.*
                                            FROM locacao_seguro
                                            JOIN seguro ON locacao_seguro.idseguro = seguro.idseguro
                                            WHERE locacao_seguro.idlocacao = ?""");
                stmt.setInt(1, rs.getInt("idlocacao"));
                rs = stmt.executeQuery();
                
                ArrayList<Seguro> seguros = new ArrayList<>();
                while (rs.next()){
                    Seguro seg = new Seguro();
                    seg.setCodigoSeguro(rs.getInt("idseguro"));
                    seg.setNome(rs.getString("nome"));
                    seg.setTipo(rs.getString("tipo"));
                    seg.setDescricao(rs.getString("descricao"));
                    seg.setValor(rs.getFloat("valor"));
                    seguros.add(seg);
                }    
                
                loc.setSegurosContratados(seguros);
                loc.setValorTotal(rs.getFloat("valor_total"));
                
                locacoes.add(loc);
            }    
            
        } catch (SQLException ex) {
             System.out.println("ERRO NA BUSCA!");
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return locacoes;
    
    }
    
    public ArrayList<Locacao> lucroTotalMesEspecifico(int mes) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Locacao> locacoes = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("""
                                        SELECT
                                            SUM(valor_total) AS total_lucro
                                        FROM
                                            locacao
                                        WHERE
                                            MONTH(data_locacao) = ?""");
            stmt.setInt(1, mes);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Locacao loc = new Locacao();
                loc.setCodigoLocacao(rs.getInt("idlocacao"));
                loc.setCodigoCliente(rs.getInt("idcliente"));
                loc.setCodigoFuncionario(rs.getInt("idfuncionario"));
                
                Veiculo veic;
                if (rs.getString("tipoVeiculo").toLowerCase().contains("nacional")){
                    veic = new VeiculoNacional();
                
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
                } else {
                    veic = new VeiculoImportado();
                
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
                }
                
                loc.setVeiculo(veic);
                loc.setDataLocacao(rs.getDate("data_locacao").toLocalDate());
                loc.setDataDevolucao(rs.getDate("data_devolucao").toLocalDate());
                loc.setTipoPagamento(rs.getString("tipo_pagamento"));
                loc.setFinalizada(rs.getBoolean("finalizada"));
                
                
                stmt = con.prepareStatement("""
                                            SELECT seguro.*
                                            FROM locacao_seguro
                                            JOIN seguro ON locacao_seguro.idseguro = seguro.idseguro
                                            WHERE locacao_seguro.idlocacao = ?""");
                stmt.setInt(1, rs.getInt("idlocacao"));
                rs = stmt.executeQuery();
                
                ArrayList<Seguro> seguros = new ArrayList<>();
                while (rs.next()){
                    Seguro seg = new Seguro();
                    seg.setCodigoSeguro(rs.getInt("idseguro"));
                    seg.setNome(rs.getString("nome"));
                    seg.setTipo(rs.getString("tipo"));
                    seg.setDescricao(rs.getString("descricao"));
                    seg.setValor(rs.getFloat("valor"));
                    seguros.add(seg);
                }    
                
                loc.setSegurosContratados(seguros);
                loc.setValorTotal(rs.getFloat("valor_total"));
                
                locacoes.add(loc);
            }    
            
        } catch (SQLException ex) {
             System.out.println("ERRO NA BUSCA!");
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return locacoes;
    
    }
}
