
package pag.pkg146.n.pkg8.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pag146N8Server {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));   
       ServerHandler handler=new ServerHandler(6789,1);
       handler.start();
       String Località;
       System.out.println("Quando vuoi effettuare la lettura inserisci la località");
       Località=input.readLine();
       handler.Lettura(Località);
    }
    
}
