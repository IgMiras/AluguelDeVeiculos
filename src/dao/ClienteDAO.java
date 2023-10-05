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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cliente;

/**
 *
 * @author alunos
 */
public class ClienteDAO {
    private Conexao conexao = new Conexao();
    
    public void create(Cliente cliente){
        Connection con = conexao.getConexao();
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
    
    
   public ArrayList<Cliente> listarClientesAlugaramVeiculoEspecifico(int codigoVeiculo) {
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT c.* FROM cliente c JOIN locacao l ON c.idcliente = l.idcliente WHERE l.idveiculo = ?");
            stmt.setInt(1, codigoVeiculo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNasci(rs.getDate("dataNascimento").toLocalDate());
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCategoriaCNH(rs.getString("categoriaCNH"));
                cliente.setNumeroCNH(rs.getString("numeroCNH"));
                cliente.setValidadeCNH(rs.getDate("validadeCNH").toLocalDate());
                cliente.setClienteOuro(rs.getBoolean("clienteOuro"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
             Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return clientes;
    }
   
   public ArrayList<Cliente> listarTodosClientes() {
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNasci(rs.getDate("dataNascimento").toLocalDate());
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCategoriaCNH(rs.getString("categoriaCNH"));
                cliente.setNumeroCNH(rs.getString("numeroCNH"));
                cliente.setValidadeCNH(rs.getDate("validadeCNH").toLocalDate());
                cliente.setClienteOuro(rs.getBoolean("clienteOuro"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
             Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return clientes;
    }
   
    public ArrayList<Cliente> listarClientesLocacaoAtraso() {
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("""
                                        SELECT c.*
                                        FROM cliente c
                                        JOIN locacao l ON c.idcliente = l.idcliente
                                        WHERE l.data_devolucao < CURRENT_DATE() AND l.finalizada = 0;""");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNasci(rs.getDate("dataNascimento").toLocalDate());
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCategoriaCNH(rs.getString("categoriaCNH"));
                cliente.setNumeroCNH(rs.getString("numeroCNH"));
                cliente.setValidadeCNH(rs.getDate("validadeCNH").toLocalDate());
                cliente.setClienteOuro(rs.getBoolean("clienteOuro"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
             Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return clientes;
    }
    
    public Cliente buscarClientePorID(int codigoCliente) {
        Connection con = conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE idcliente = ?");
            stmt.setInt(1,codigoCliente);
            rs = stmt.executeQuery();
            
            Cliente cliente = new Cliente();
            
            if (rs.next()){
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNasci(rs.getDate("dataNascimento").toLocalDate());
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCategoriaCNH(rs.getString("categoriaCNH"));
                cliente.setNumeroCNH(rs.getString("numeroCNH"));
                cliente.setValidadeCNH(rs.getDate("validadeCNH").toLocalDate());
                cliente.setClienteOuro(rs.getBoolean("clienteOuro"));
                
                Conexao.closeConnection(con, stmt, rs);
                return cliente;
            }
            
        } catch (SQLException ex) {
             Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return null;
    }
}
