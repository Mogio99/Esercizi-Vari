import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EsercizioQuadro extends HttpServlet{
    
    Connection connection;
    
    @Override
    public void init() throws ServletException {
    }
    
    @Override
    public void doPost(HttpServletRequest richiesta, HttpServletResponse risposta) throws IOException{
        
        risposta.setContentType("text/html");
        PrintWriter out = risposta.getWriter();
                
        String url = "jdbc:mysql://192.168.1.150:3306/2013mogioni";
        String username = "mogioni";
        String password = "alessio";


        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            out.println(e.toString());
        }

        if(this.connection == null)
        {
            out.println("\nerror");
            return;
        }
        
        String str =richiesta.getParameter("function");
        
        if (str.equals("ElencoQuadri"))
        {
            try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM QUADRO");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                out.println(resultSet.getString("Codice") + "<br>");
                out.println(resultSet.getString("Titolo") + "<br>");
                out.println(resultSet.getString("Autore") + "<br>");
                out.println(resultSet.getString("CorrenteArtistica") + "<br>");
                out.println(resultSet.getString("Altezza(cm)") + "<br>");
                out.println(resultSet.getString("Larghezza(cm)") + "<br>");
                out.println(resultSet.getString("DataCreazione") + "<br>");
                out.println(resultSet.getString("Descrizione") + "<br>");
                out.println("<br>");
            }
            } catch (SQLException e) {
                out.println(e.toString());
            }
        }
        else
            if(str.equals("NewQuadro"))
            {
                String Codice=richiesta.getParameter("codice");
                String Titolo=richiesta.getParameter("titolo");
                String Autore=richiesta.getParameter("autore");
                String CorrenteArtistica=richiesta.getParameter("correnteartistica");
                String Altezza=richiesta.getParameter("altezza");
                String Larghezza=richiesta.getParameter("larghezza");
                String Data=richiesta.getParameter("datacreazione");
                String Descrizione=richiesta.getParameter("descrizione");
                try {
                PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO QUADRI VALUES (""+Codice+""+Titolo+""+""+Autore+""+CorrenteArtistica+""+Altezza+""+Larghezza+""+DataCreazione+""+Descrizione)");
                preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    out.println(e.toString());
                }
            }
        else
            if(str.equals("FindQuandro"))
            {
                try {
                PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM QUADRO WHERE Titolo='" + richiesta.getParameter("titolo")+"'");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                {
                    out.println(resultSet.getString("Codice") + "<br>");
                    out.println(resultSet.getString("Titolo") + "<br>");
                    out.println(resultSet.getString("Autore") + "<br>");
                    out.println(resultSet.getString("CorrenteArtistica") + "<br>");
                    out.println(resultSet.getString("Altezza(cm)") + "<br>");
                    out.println(resultSet.getString("Larghezza(cm)") + "<br>");
                    out.println(resultSet.getString("DataCreazione") + "<br>");
                    out.println(resultSet.getString("Descrizione") + "<br>");
                    out.println("<br>");
                }
                } catch (SQLException e) {
                    out.println(e.toString());
                }
            }
        else
            if(str.equals("ViewQuadro"))
            {
                try {
                PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM QUADRO ORDER BY DataCreazione");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                {
                    out.println(resultSet.getString("Codice") + "<br>");
                    out.println(resultSet.getString("Titolo") + "<br>");
                    out.println(resultSet.getString("Autore") + "<br>");
                    out.println(resultSet.getString("CorrenteArtistica") + "<br>");
                    out.println(resultSet.getString("Altezza(cm)") + "<br>");
                    out.println(resultSet.getString("Larghezza(cm)") + "<br>");
                    out.println(resultSet.getString("DataCreazione") + "<br>");
                    out.println(resultSet.getString("Descrizione") + "<br>");
                    out.println("<br>");
                }
                } catch (SQLException e) {
                    out.println(e.toString());
                }
            }
        else
            if(str.equals("A4"))
            {
                try {
                PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM QUADRO");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                {
                    out.println(resultSet.getString("Titolo") + "<br>");
                }
                } catch (SQLException e) {
                    out.println(e.toString());
                }
            }
        
        try {
            connection.close();
        } catch (SQLException ex) {
            out.println("ERRORE!|!!!VFDJFASDFJ: " + ex + "<br>");
        }
        risposta.setContentType("text/html");
    }

}