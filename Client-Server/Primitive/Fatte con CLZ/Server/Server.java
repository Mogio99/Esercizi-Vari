package javaapplication6.Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    
    ServerSocket s;
    Socket client;
    DataOutputStream outClient;
    BufferedReader inClient;
    BufferedReader tastiera;
    
    public void instanzia(){
        
        try {
             
            s = new ServerSocket(6789);           
            client = s.accept();
            s.close();
            outClient = new  DataOutputStream(client.getOutputStream());
            inClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            
        }
        catch(IOException ex) {
            System.out.println("Pippo");
        }
    }
        public void comunica() {
            
        try {
            
            System.out.println("Inserisci un msg: ");
            String msgUtente = tastiera.readLine();
            outClient.writeBytes(msgUtente+"\n");
            String msgClient = inClient.readLine();
            System.out.println("Msg del client: "+msgClient);
            
        } 
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    
    
}
