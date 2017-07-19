package gamification.controller;

import gamification.dao.UsuarioDao;
import gamification.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elton
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pega os valores das variáveis
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        // Verifica se existem valores preenchidos
        if (login == null || login.equals("") || senha == null || senha.equals("")) {
            request.setAttribute("erro", "Preencha os campos com o valores validos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
        try {
            // Faz a autenticação
            Usuario usuario = UsuarioDao.autenticar(login, senha);
            
            // Guarda o usuario na session
            request.getSession().setAttribute("usuario", usuario);
            
            // Redireciona para a jsp de tópicos
            response.sendRedirect("topico");
        } catch (Exception ex) {
            // Guarda o erro no request
            request.setAttribute("erro", ex.getMessage());
            
            // Redireciona de volta para a jsp de login
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
