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
        
        Autenticador autenticador = new Autenticador();
        try {
            // Faz a autenticação
            String nomeUsuario = autenticador.autenticar(login, senha);
            
            // Guarda o nome no request
            request.setAttribute("nome", nomeUsuario);
            
            // Redireciona para a jsp de tópicos
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
        } catch (Exception ex) {
            // Guarda o erro no request
            request.setAttribute("erro", ex.getMessage());
            
            // Redireciona de volta para a jsp de login
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
