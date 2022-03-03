package javaapplication6.MultiServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiServer {

    ServerSocket s;
    
    
    void avvio() {
        
        try {
            s = new ServerSocket(6789);
            while(true){
                
                System.out.println("Mi metto in attesa di connesione");
                Socket client = s.accept();
                System.out.println("Connessione ricevuta "+client);
                
                ServerThread sT = new ServerThread(client);
                sT.start();
            }  
        } 
        catch (IOException ex) {
            Logger.getLogger(MultiServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                s.close();
            } 
            catch (IOException ex){
                Logger.getLogger(MultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }   
}
