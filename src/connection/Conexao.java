package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class Conexao {
    private final String URL = "jdbc:mysql://localhost:3306/alugueldeveiculos";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private Connection conexao = null;
    
    public Connection getConexao(){
        try {
            if (this.conexao == null){
                this.conexao = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Nova conexao iniciada");
                return this.conexao;
            } else {
                System.out.println("Ja tinha conexao");
                return this.conexao;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void closeConnection(Connection con){
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
        closeConnection(con);
        
        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con, stmt);
        
        try {
            
            if (rs != null) {
                rs.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
