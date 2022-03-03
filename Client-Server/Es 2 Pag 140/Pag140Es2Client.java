
package pag.pkg140.es.pkg2.client;
import java.io.*;
public class Pag140Es2Client {

    public static void main(String[] args) {
        try{
            Client connection=new Client("localhost",6789,0);
            String Number=connection.Listen();
            System.out.println("Numero Assegnato: "+Number);
        }
        catch(IOException ex)
         {
             System.out.println("Errore");  
         }
    }
    
}
