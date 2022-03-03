
package pag.pkg140.es.pkg3.client;
import java.io.*;

public class Pag140Es3Client {

    public static void main(String[] args) {
        try{
            String bomb="";
            int tmpbomb;
            Client connection=new Client("localhost",6789,0);
            while(!bomb.equals("win") && !bomb.equals("lose"))
            {
                bomb=connection.Listen();
                if(!bomb.equals("win"))
                {
                    tmpbomb=Integer.parseInt(bomb);
                    System.out.println(tmpbomb);
                    tmpbomb--;
                    if(tmpbomb==0)
                    {
                        connection.Send("win");
                        bomb="lose";
                    }
                    else
                    {
                              bomb=""+tmpbomb;
                              connection.Send(bomb);
                    }
                }                
            }
            if(bomb.equals("win"))
            {
                System.out.println("You win");
            }
            if(bomb.equals("lose"))
            {
                 System.out.println("You lose");
            }
        }
         catch(IOException ex)
         {
             System.out.println("Errore");  
         }
    }
    
}
