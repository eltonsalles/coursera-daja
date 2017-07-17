package gamification.auth;

import gamification.utils.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Elton
 */
public class Autenticador {

    public String autenticar(String login, String senha) throws Exception {
        try (Connection c = Conn.getConnection()) {
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
