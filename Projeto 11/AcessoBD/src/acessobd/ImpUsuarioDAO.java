package acessobd;

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
public class ImpUsuarioDAO implements UsuarioDAO {

    private Connection conn;

    /**
     * Registro do drive usado para conexão com o banco de dados
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Retorna a conexão do banco de dados
     *
     * @return
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException {
        if (this.conn == null || this.conn.isClosed()) {
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/coursera", "root", "root");
        }

        return this.conn;
    }

    @Override
    public void inserir(Usuario u) {
        try (Connection c = this.getConnection()) {
            String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getNome());
            stmt.setString(4, u.getSenha());
            stmt.setInt(5, u.getPontos());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            throw new RuntimeException("Não foi possível executar o acesso!", e);
        }
    }

    @Override
    public Usuario recuperar(String login) {
        try (Connection c = this.getConnection()) {
            String sql = "SELECT * FROM usuario WHERE login = ?";

            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, login);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario(
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getInt("pontos"));

                return u;
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            throw new RuntimeException("Não foi possível executar o acesso!", e);
        }

        return null;
    }

    @Override
    public void adicionarPontos(String login, int pontos) {
        try (Connection c = this.getConnection()) {
            String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";

            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, pontos);
            stmt.setString(2, login);

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            throw new RuntimeException("Não foi possível executar o acesso!", e);
        }
    }

    @Override
    public List<Usuario> ranking() {
        List<Usuario> ranking = new ArrayList<>();

        try (Connection c = this.getConnection()) {
            String sql = "SELECT * FROM usuario ORDER BY pontos DESC";

            PreparedStatement stmt = c.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getInt("pontos"));

                ranking.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            throw new RuntimeException("Não foi possível executar o acesso!", e);
        }

        return ranking;
    }
}
