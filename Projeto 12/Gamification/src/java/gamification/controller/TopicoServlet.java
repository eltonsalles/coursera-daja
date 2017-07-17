package gamification.controller;

import gamification.dao.TopicoDao;
import gamification.dao.UsuarioDao;
import gamification.model.Topico;
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
@WebServlet(urlPatterns = {"/inserirTopico"})
public class TopicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("inserir-topico.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pega o usuário que está na session
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        // Pega os valores das variáveis
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        
        // Verifica se existem valores preenchidos
        if (titulo == null || titulo.equals("") || conteudo == null || conteudo.equals("") || usuario == null) {
            request.setAttribute("erro", "Preencha os campos com o valores validos.");
            request.getRequestDispatcher("inserir-topico.jsp").forward(request, response);
        }
        
        Topico topico = new Topico(titulo, conteudo, usuario);
        try {
            // Faz a inserção no banco de dados
            TopicoDao.inserir(topico);
            UsuarioDao.adicionarPontos(usuario.getLogin(), 10);
            
            // Redireciona para a jsp de topicos
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
        } catch (SQLException ex) {
            // Guarda o erro no request
            request.setAttribute("erro", ex.getMessage());
            
            // Redireciona de volta para a jsp de inserir-topico
            request.getRequestDispatcher("inserir-topico.jsp").forward(request, response);
        }
    }
}
