import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class TestDatabase extends HttpServlet {

    Connection connection;
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "jdbc:mysql://192.168.1.150:3306/2013mogioni";
        String username = "mogioni";
        String password = "alessio";


        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            resp.getWriter().write(e.toString());
        }

        if(this.connection == null)
        {
            resp.getWriter().write("\nerror");
            return;
        }

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM ADDETTO");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                resp.getWriter().write(resultSet.getString("CognAdd") + "\n");
            }
        } catch (SQLException e) {
            resp.getWriter().write(e.toString());
        }
    }
}
