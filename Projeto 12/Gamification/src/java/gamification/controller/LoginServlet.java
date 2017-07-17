package gamification.controller;

import gamification.auth.Autenticador;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Autenticador autenticador = new Autenticador();
        
        try {
            String nomeUsuario = autenticador.autenticar(login, senha);
            request.setAttribute("nome", nomeUsuario);
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
