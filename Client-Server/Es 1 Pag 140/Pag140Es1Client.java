
package pag.pkg140.es.pkg1.client;
import pag.pkg140.es.pkg1.client.Client;
import java.io.*;

public class Pag140Es1Client {

    public static void main(String[] args) throws IOException {
           try{
               BufferedReader input;
                input = new BufferedReader(new InputStreamReader(System.in));
               System.out.println("Inserire operando 1");
               String op1=input.readLine();
                System.out.println("Inserire operando 2");
               String op2=input.readLine();
                System.out.println("Inserire operatore");
               String oper=input.readLine();
           
               Client Conn=new Client("localhost",6789,0);
               Conn.Send(op1);
               Conn.Send(op2);
               Conn.Send(oper);
               String result=Conn.Listen();
               Conn.Adios();
               System.out.println(result);
           }
            catch(IOException ex)
         {
             System.out.println("Errore");  
         }
            
            
        
    }
    
}
