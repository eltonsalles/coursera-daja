package gamification.controller;

import gamification.dao.UsuarioDao;
import gamification.model.Usuario;
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
@WebServlet(urlPatterns = {"/ranking"})
public class RankingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> ranking = UsuarioDao.ranking();
        request.setAttribute("ranking", ranking);
        request.getRequestDispatcher("ranking.jsp").forward(request, response);
    }
}
