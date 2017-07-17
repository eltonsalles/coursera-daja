package gamification.utils;

import gamification.auth.Autenticador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elton
 */
public class Conn {
    private static String HOST = "jdbc:postgresql://localhost/coursera";
    private static String USER = "postgres";
    private static String PASS = "root";
    
    /**
     * Registra o driver na Garbage Collection
     */
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Autenticador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Retorna a conexão
     * 
     * @return 
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(HOST, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível se conectar ao banco de dados.", ex);
        }
    }
}
