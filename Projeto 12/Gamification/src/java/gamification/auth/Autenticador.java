package gamification.auth;

import gamification.model.Usuario;
import gamification.utils.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Elton
 */
public class Autenticador {

    public Usuario autenticar(String login, String senha) throws Exception {
        try (Connection c = Conn.getConnection()) {
            String sql = "select * from usuario where login = ? and senha = ?";
            
            PreparedStatement stmt = c.prepareStatement(sql);
            
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("nome"),
                        rs.getInt("pontos"));
                
                return usuario;
            } else {
                throw new Exception("Não foi possível autenticar o usuário!");
            }
        }
    }
}
