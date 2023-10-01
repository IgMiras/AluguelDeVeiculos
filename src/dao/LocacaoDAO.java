/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import models.Locacao;
import java.util.ArrayList;
import models.Seguro;
import models.Veiculo;

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
                                            locacao.data_locacao,
                                            locacao.data_devolucao,
                                            locacao.valor_total,
                                            locacao.tipo_pagamento,
                                            locacao.finalizada,
                                            veiculo.idveiculo,
                                            veiculo.tipoVeiculo,
                                            veiculo.nomeModelo,
                                            veiculo.montadora,
                                            veiculo.anoFabricacao,
                                            veiculo.anoModelo,
                                            veiculo.placa,
                                            veiculo.categoria,
                                            veiculo.valorFipe,
                                            veiculo.valorDiaria,
                                            veiculo.categoriaCNHNecessaria,
                                            veiculo.alugado,
                                            veiculo.taxaImpostoEstadual
                                        FROM
                                            locacao
                                        INNER JOIN veiculo ON locacao.idveiculo = veiculo.idveiculo
                                        WHERE
                                            locacao.idcliente = [ID_DO_CLIENTE];""");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Locacao loc = new Locacao();
                loc.setCodigoLocacao(rs.getInt("idlocacao"));
                loc.setDataLocacao(rs.getDate("data_locacao").toLocalDate());
                loc.setDataDevolucao(rs.getDate("data_devolucao").toLocalDate());
                loc.setValorTotal();
                if (rs.getString("tipoVeiculo").toLowerCase().contains("nacional")){
                    
                }
            }
        } catch (SQLException ex) {
             Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return clientes;
    
    
}
