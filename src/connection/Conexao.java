package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/alugueldeveiculos";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection conexao;
    
    public static Connection getConexao(){
        try {
            if (conexao == null){
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Nova conexao iniciada");
                return conexao;
            } else {
                System.out.println("Ja tinha conexao");
                return conexao;
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
    
}
