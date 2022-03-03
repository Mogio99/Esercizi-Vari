import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Eventi extends HttpServlet{
    
    private Connection connection=null;
    
    @Override
    public void init() throws ServletException {
         try {
             this.connection = DriverManager.getConnection("jdbc:mysql://192.168.1.150:3306/2012mogioni", "mogioni", "alessio");
             Statement start=connection.createStatement();
             start.executeUpdate("CREATE TABLE IF NOT EXISTS `2012mogioni`.`EVENTO` (\n" +
                                 "        `CodiceEvento` INT NOT NULL ,\n" +
                                 "        `Nome` VARCHAR( 25 ) NOT NULL ,\n" +
                                 "        `Tipologia` VARCHAR( 25 ) NOT NULL ,\n" +
                                 "        `Data` DATE NOT NULL ,\n" +
                                 "        `Ora` TIME NOT NULL ,\n" +
                                 "        `Citta` VARCHAR( 25 ) NOT NULL ,\n" +
                                 "        `MaxPartecipanti` INT( 25 ) NOT NULL ,\n" +
                                 "        `NumeroIscritti` INT( 25 ) NOT NULL ,\n" +
                                 "        `QuotaPartecipazione` DECIMAL NOT NULL ,\n" +
                                 "        PRIMARY KEY (  `CodiceEvento` )\n" +
                                 "        )");
         } catch (SQLException ex) {
             Logger.getLogger(Eventi.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    }
    
    
    
    @Override
    public void doPost(HttpServletRequest richiesta, HttpServletResponse risposta) throws IOException{
        
        risposta.setContentType("text/html");
        PrintWriter out = risposta.getWriter();
                

        if(this.connection == null)
        {
            out.println("\nerror");
            return;
        }
        
        String str =richiesta.getParameter("function");
        
        if (str.equals("query1"))
        {
            try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM EVENTO WHERE Citta='Roma' ORDER BY Data DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                out.println(resultSet.getString("Data") + "<br>");
                out.println(resultSet.getString("Nome") + "<br>");
                out.println(resultSet.getString("Tipologia") + "<br>");
                out.println(resultSet.getString("QuotaPartecipazione") + "<br>");
                out.println("<br>");
            }
            } catch (SQLException e) {
                out.println(e.toString());
            }
        }
        else
            if(str.equals("query2"))
            {
                try {
                PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM EVENTO WHERE Data>='" + richiesta.getParameter("testo1")+"' AND Data<='" + richiesta.getParameter("testo2")+"'");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                {
                    out.println(resultSet.getString("CodiceEvento") + "<br>");
                    out.println(resultSet.getString("Nome") + "<br>");
                    out.println(resultSet.getString("Tipologia") + "<br>");
                    out.println(resultSet.getString("Data") + "<br>");
                    out.println(resultSet.getString("Ora") + "<br>");
                    out.println(resultSet.getString("Citta") + "<br>");
                    out.println(resultSet.getString("MaxPartecipanti") + "<br>");
                    out.println(resultSet.getString("NumeroIscritti") + "<br>");
                    out.println(resultSet.getString("QuotaPartecipazione") + "<br>");
                    out.println("<br>");
                }
                } catch (SQLException e) {
                    out.println(e.toString());
                }
            }
        else
            if(str.equals("query3"))
            {
                try {
                PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM EVENTO WHERE Citta='" + richiesta.getParameter("filtrocitta")+"' AND Data='" + richiesta.getParameter("filtrodata")+"' AND NumeroIscritti='" + richiesta.getParameter("filtropart")+"'");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                {
                    out.println(resultSet.getString("CodiceEvento") + "<br>");
                    out.println(resultSet.getString("Nome") + "<br>");
                    out.println(resultSet.getString("Tipologia") + "<br>");
                    out.println(resultSet.getString("Data") + "<br>");
                    out.println(resultSet.getString("Ora") + "<br>");
                    out.println(resultSet.getString("Citta") + "<br>");
                    out.println(resultSet.getString("MaxPartecipanti") + "<br>");
                    out.println(resultSet.getString("NumeroIscritti") + "<br>");
                    out.println(resultSet.getString("QuotaPartecipazione") + "<br>");
                    out.println("<br>");
                }
                } catch (SQLException e) {
                    out.println(e.toString());
                }
            }
        else
            if(str.equals("query4"))
            {
                try {
                PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT SUM(QuotaPartecipazione) as Somma FROM EVENTO WHERE Data='" + richiesta.getParameter("testo3")+"'");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                {
                    out.println(resultSet.getString("Somma") + "<br>");
                }
                } catch (SQLException e) {
                    out.println(e.toString());
                }
            }
        
        try {
            connection.close();
        } catch (SQLException ex) {
            out.println("ERRORE!" + ex + "<br>");
        }
        risposta.setContentType("text/html");
    }

}