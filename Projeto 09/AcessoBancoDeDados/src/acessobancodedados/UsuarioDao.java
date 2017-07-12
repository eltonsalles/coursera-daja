package acessobancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
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
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
        }
    }
    
    public static List<UsuarioModel> todosUsuarios() {
        List<UsuarioModel> todos = new ArrayList<>();
        
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarios", "root", "root")) {
            
            String sql = "select login, nome, email from usuario";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {                
                UsuarioModel u = new UsuarioModel();
                u.setLogin(result.getString("login"));
                u.setNome(result.getString("nome"));
                u.setEmail(result.getString("email"));
                
                todos.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível executar o acesso!", e);
        }
        
        return todos;
    }
    
    public static void inserirUsuario(UsuarioModel u) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarios", "root", "root123")) {
            
            String sql = "insert into usuario(login, nome, email) values(?, ?, ?)";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getEmail());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível executar o acesso!", e);
        }
    }
}
