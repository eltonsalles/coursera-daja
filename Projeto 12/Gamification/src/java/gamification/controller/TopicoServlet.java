package gamification.controller;

import gamification.dao.ComentarioDao;
import gamification.dao.TopicoDao;
import gamification.model.Comentario;
import gamification.model.Topico;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elton
 */
@WebServlet(urlPatterns = {"/topico"})
public class TopicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idTopico = request.getParameter("id");

        if (idTopico == null || idTopico.equals("")) {
            // Recupera a lista de tópicos
            List<Topico> topicos = TopicoDao.recuperar();

            // Guarda a lista no request
            request.setAttribute("topicos", topicos);

            // Redireciona para a jsp topicos
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
        }

        Topico topico = TopicoDao.obterTopico(Integer.parseInt(idTopico));
        List<Comentario> comentarios = ComentarioDao.recuperar(Integer.parseInt(idTopico));

        // Guarda o tópico
        request.setAttribute("topico", topico);
        request.setAttribute("comentarios", comentarios);

        // Redireciona para a jsp exibir-topico
        request.getRequestDispatcher("exibir-topico.jsp").forward(request, response);
    }
}
