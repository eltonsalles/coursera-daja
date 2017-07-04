package tradutor;

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
@WebServlet(urlPatterns = "/Traduzir")
public class TradutorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupera o parâmetro
        String palavra = request.getParameter("palavra");
        
        // Verifica se existe e se não está vazio
        if (palavra == null || palavra.equals("")) {
            request.setAttribute("erro", true);
            request.getRequestDispatcher("traduzir.jsp").forward(request, response);
        }
        
        // Faz a tradução
        Tradutor tradutor = new Tradutor(palavra);
        String traducao = tradutor.traduzirPalavra();
        
        // Verifica se a palavra foi traduzida
        if (palavra.equals(traducao)) {
            request.setAttribute("palavraNaoEncontrada", true);
            request.getRequestDispatcher("traduzir.jsp").forward(request, response);
        }
        
        // Tudo ok! Retorna a tradução
        request.setAttribute("traducao", traducao);
        request.getRequestDispatcher("traduzir.jsp").forward(request, response);
    }
}
