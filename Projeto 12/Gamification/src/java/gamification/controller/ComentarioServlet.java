package gamification.controller;

import gamification.dao.ComentarioDao;
import gamification.dao.TopicoDao;
import gamification.dao.UsuarioDao;
import gamification.model.Comentario;
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
@WebServlet(urlPatterns = {"/comentario"})
public class ComentarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pega o usuário que está na session
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        // Pega os valores das variáveis
        String id = request.getParameter("id_topico");
        String comentario = request.getParameter("comentario");
        
        // Verifica se existem valores preenchidos
        if (comentario == null || comentario.equals("") || usuario == null) {
            request.getSession().setAttribute("erro", "Preencha os campos com o valores validos.");
            response.sendRedirect("topico?id=" + id);
            return;
        }
        
        // Criar um objeto do tipo tópico
        Topico topico = TopicoDao.obterTopico(Integer.parseInt(id));
        
        Comentario c = new Comentario(comentario, usuario, topico);
        try {
            // Faz a inserção no banco de dados
            ComentarioDao.inserir(c);
            UsuarioDao.adicionarPontos(usuario.getLogin(), 3);
        } catch (SQLException ex) {
            // Guarda o erro no request
            request.setAttribute("erro", ex.getMessage());
        }
        
        // Redireciona para a exibição do tópico conforme o id
        response.sendRedirect("topico?id=" + id);
    }
}
