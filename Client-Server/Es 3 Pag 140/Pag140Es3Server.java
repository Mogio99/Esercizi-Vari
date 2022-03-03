
package pag.pkg140.es.pkg3.server;
import java.io.*;
public class Pag140Es3Server {

    public static void main(String[] args) {
        try{
            String bomb="";
            Double random;
            random =(Math.random()*10);         
            int tmpbomb=random.intValue();
            SingleServer connection=new SingleServer(6789,0);
            connection.Send(""+tmpbomb);
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
