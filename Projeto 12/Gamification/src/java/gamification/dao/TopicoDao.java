package gamification.dao;

import gamification.model.Topico;
import gamification.utils.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Elton
 */
public class TopicoDao {
    /**
     * Faz a inserção de um novo tópico
     * 
     * @param topico
     * @throws SQLException 
     */
    public static void inserir(Topico topico) throws SQLException {
        try (Connection c = Conn.getConnection()) {
            String sql = "insert into topico (titulo, conteudo, login) values (?, ?, ?)";
            
            PreparedStatement stmt = c.prepareStatement(sql);
            
            stmt.setString(1, topico.getTitulo());
            stmt.setString(2, topico.getConteudo());
            stmt.setString(3, topico.getUsuario().getLogin());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível cadastrar o tópico.", e);
        }
    }
}
