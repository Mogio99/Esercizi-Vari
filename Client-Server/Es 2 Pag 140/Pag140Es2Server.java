
package pag.pkg140.es.pkg2.server;
import java.io.*;

public class Pag140Es2Server {

    public static void main(String[] args) {
        try{
            int actual=1;
            String tosend;
            SingleServer connection=null;
            while(true)
            {
                connection=new SingleServer(6789,0);
                tosend=""+actual;
                connection.Send(tosend);
                connection.Adios();
                actual++;
            }
        }
        catch(IOException ex)
         {
             System.out.println("Errore");  
         }
    }
}
