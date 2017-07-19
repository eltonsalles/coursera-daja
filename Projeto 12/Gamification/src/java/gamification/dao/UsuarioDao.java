package gamification.dao;

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
public class UsuarioDao {
    
    /**
     * Faz a autenticação do usuário
     * 
     * @param login
     * @param senha
     * @return
     * @throws Exception 
     */
    public static Usuario autenticar(String login, String senha) throws Exception {
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
    
    /**
     * Adiciona pontos ao usuário
     * 
     * @param login
     * @param pontos 
     */
    public static void adicionarPontos(String login, int pontos) {
        try (Connection c = Conn.getConnection()) {
            String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";

            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, pontos);
            stmt.setString(2, login);

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível adicionar pontos ao usuário.", e);
        }
    }
    
    /**
     * Obtém o usuário pelo login
     * 
     * @param login
     * @return 
     */
    public static Usuario obterUsuario(String login) {
        try (Connection c = Conn.getConnection()) {
            String sql = "select * from usuario where login = ?";

            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, login);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("login"), 
                        rs.getString("email"), 
                        rs.getString("nome"), 
                        rs.getInt("pontos"));
                
                return usuario;
            }
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível encontrar o usuário.", e);
        }
        
        return null;
    }
    
    /**
     * Traz uma lista de usuários ordenado pelos maios pontos
     * 
     * @return 
     */
    public static List<Usuario> ranking() {
        List<Usuario> lista = new ArrayList<>();
        
        try (Connection c = Conn.getConnection()) {
            String sql = "select * from usuario order by pontos desc";

            PreparedStatement stmt = c.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                Usuario usuario = new Usuario(
                        rs.getString("login"), 
                        rs.getString("email"), 
                        rs.getString("nome"), 
                        rs.getInt("pontos"));
                
                lista.add(usuario);
            }
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível listar os usuários.", e);
        }
        
        return lista;
    }
}
