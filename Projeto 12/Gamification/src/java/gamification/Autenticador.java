package gamification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elton
 */
public class Autenticador {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Autenticador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String autenticar(String login, String senha) throws Exception {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/coursera", "postgres", "root")) {
            String sql = "select nome from usuario where login = ? and senha = ?";
            
            PreparedStatement stmt = c.prepareStatement(sql);
            
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("nome");
            } else {
                throw new Exception("Não foi possível autenticar o usuário!");
            }
        }
    }
}
