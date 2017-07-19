package gamification.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            throw new RuntimeException("Erro no registro do driver.", ex);
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
