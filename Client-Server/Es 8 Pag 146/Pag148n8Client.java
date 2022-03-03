
package pag148n8client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pag148n8Client {

    public static void main(String[] args) {
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));     
            Client connection=new Client("localhost",6789,1);
            String Area,matricola;
            System.out.println("Inserisci area geografica contatore");
            Area=input.readLine();
            System.out.println("Inserisci matricola contatore");
            matricola=input.readLine();
            double consumi=Math.random();
            connection.Send(Area);
            while(true)
            {
                connection.Listen();
                connection.Send(matricola);
                connection.Send(""+consumi);
            } 
        }
        catch(Exception ex)
        {
               System.out.println("Errore"); 
        }     
    }
    
}
