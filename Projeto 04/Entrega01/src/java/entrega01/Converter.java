package entrega01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elton
 */
@WebServlet(urlPatterns = "/Converter")
public class Converter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipoConversao = request.getParameter("tipoConversao");
        int valor = Integer.parseInt(request.getParameter("valor"));
        int result = 0;
        
        if (tipoConversao.equalsIgnoreCase("celsius")) {
            result = ((valor * 9) / 5) + 32;
        } else if (tipoConversao.equalsIgnoreCase("fahrenheit")) {
            result = ((valor - 32) * 5) / 9;
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Conversão de valores</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>O resultado da conversão foi: " + result + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
