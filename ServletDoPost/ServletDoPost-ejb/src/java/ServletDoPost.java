import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletDoPost extends HttpServlet {
    public int cont;
    public int somma;
    public double media;
    
    @Override
    public void init() throws ServletException {
        cont=0;
        somma=0;
        media=0;
    }
    
    @Override
    public void doPost(HttpServletRequest richiesta, HttpServletResponse risposta) throws IOException{
        
        String tmp= richiesta.getParameter("voti");
        int voto = Integer.parseInt(tmp);
        
        risposta.setContentType("text/html");
        PrintWriter out = risposta.getWriter();
        
        cont++;
        somma=somma+voto;
        media=somma/cont;
        
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Questa e' la gestione dei voti di EDU con le Servlet</h1>");
        out.println("<p1>Ciao Edu sono presenti in tutto "+cont+" voti</p1><br>");
        out.println("<p1>La loro media e' "+media+"</p1>");
        out.println("</body>");
        out.println("</html>");
    }
}