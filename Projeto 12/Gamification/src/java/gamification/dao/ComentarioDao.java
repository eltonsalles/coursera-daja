package gamification.dao;

import gamification.model.Comentario;
import gamification.model.Topico;
import gamification.model.Usuario;
import gamification.utils.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elton
 */
public class ComentarioDao {
    /**
     * Faz a inserção de um novo comentário
     * 
     * @param comentario
     * @throws SQLException 
     */
    public static void inserir(Comentario comentario) throws SQLException {
        try (Connection c = Conn.getConnection()) {
            String sql = "insert into comentario (comentario, login, id_topico) values (?, ?, ?)";
            
            PreparedStatement stmt = c.prepareStatement(sql);
            
            stmt.setString(1, comentario.getComentario());
            stmt.setString(2, comentario.getUsuario().getLogin());
            stmt.setInt(3, comentario.getTopico().getId());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível cadastrar o comentário.", e);
        }
    }
    
    /**
     * Recupera a lista de comentários
     * 
     * @param id
     * @return 
     */
    public static List<Comentario> recuperar(int id) {
        List<Comentario> comentarios = new ArrayList<>();
        
        try (Connection c = Conn.getConnection()) {
            String sql = "select * from comentario where id_topico = ?";
            
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Usuario usuario = UsuarioDao.obterUsuario(rs.getString("login"));
                Topico topico = TopicoDao.obterTopico(id);
                
                Comentario comentario = new Comentario(rs.getString("comentario"), usuario, topico);
                
                comentarios.add(comentario);
            }
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível recuperar os comentários.", e);
        }
        
        return comentarios;
    }
}
