package gamification.dao;

import gamification.model.Usuario;
import gamification.utils.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Elton
 */
public class UsuarioDao {
    /**
     * Faz a inserção de um novo usuário
     * 
     * @param usuario
     * @throws SQLException 
     */
    public static void inserir(Usuario usuario) throws SQLException {
        try (Connection c = Conn.getConnection()) {
            String sql = "insert into usuario (login, email, nome, senha, pontos) values (?, ?, ?, ?, 0)";
            
            PreparedStatement stmt = c.prepareStatement(sql);
            
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getNome());
            stmt.setString(4, usuario.getSenha());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível cadastrar o usuário.", e);
        }
    }
}
