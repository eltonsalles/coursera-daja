package gamification.controller;

import gamification.dao.UsuarioDao;
import gamification.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elton
 */
@WebServlet(urlPatterns = {"/cadastro"})
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pega os valores das variáveis
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        String senha1 = request.getParameter("senha1");
        String senha2 = request.getParameter("senha2");

        // Verifica se existem valores preenchidos
        if (login == null || login.equals("")
                || email == null || email.equals("")
                || nome == null || nome.equals("")
                || senha1 == null || senha1.equals("")
                || senha2 == null || senha2.equals("")
                || !senha1.equals(senha2)) {
            // Guarda o erro no request
            request.setAttribute("erro", "Preencha os campos com o valores validos.");
            
            // Redireciona de volta para a jsp de cadastro
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        }

        Usuario usuario = new Usuario(login, email, nome, senha1);
        try {
            // Faz a inserção no banco de dados
            UsuarioDao.inserir(usuario);
            
            // Redireciona para a jsp de login para que o usuário possa logar
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (SQLException ex) {
            // Guarda o erro no request
            request.setAttribute("erro", ex.getMessage());
            
            // Redireciona de volta para a jsp de cadastro
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        }
    }
}
