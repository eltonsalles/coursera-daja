package gamification.dao;

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
    
    /**
     * Retorna todos os tópicos
     * 
     * @return 
     */
    public static List<Topico> recuperar() {
        List<Topico> topicos = new ArrayList<>();
        
        try (Connection c = Conn.getConnection()) {
            String sql = "select * from topico";
            
            PreparedStatement stmt = c.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Usuario usuario = UsuarioDao.obterUsuario(rs.getString("login"));
                Topico topico = new Topico(
                        rs.getString("titulo"), 
                        rs.getString("conteudo"),
                        usuario);
                topico.setId(rs.getInt("id_topico"));
                
                topicos.add(topico);
            }
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível cadastrar o tópico.", e);
        }
        
        return topicos;
    }
    
    /**
     * Obtém um tópico pelo id
     * 
     * @param id
     * @return 
     */
    public static Topico obterTopico(int id) {
        try (Connection c = Conn.getConnection()) {
            String sql = "select * from topico where id_topico = ?";

            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = UsuarioDao.obterUsuario(rs.getString("login"));
                Topico topico = new Topico(
                        rs.getString("titulo"), 
                        rs.getString("conteudo"),
                        usuario);
                topico.setId(rs.getInt("id_topico"));
                
                return topico;
            }
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível adicionar pontos ao usuário.", e);
        }
        
        return null;
    }
}
