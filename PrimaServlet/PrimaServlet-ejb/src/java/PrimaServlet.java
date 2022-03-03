import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class PrimaServlet extends HttpServlet {
    public int cont;
    
    @Override
    public void init() throws ServletException {
        cont=0;
    }
    
    public void doGet(HttpServletRequest richiesta, HttpServletResponse risposta) throws IOException{
        
        risposta.setContentType("text/html");
        
        PrintWriter out = risposta.getWriter();
        cont++;
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Questa e' la mia prima Servlet</h1>");
        out.println("<p1><h1>Benvenuto visitatore numero "+cont+" hai vinto un IPHONE X</h1></p1>");
        out.println("</body>");
        out.println("</html>");

    }
}
