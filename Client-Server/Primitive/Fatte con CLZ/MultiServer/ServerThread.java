package javaapplication6.MultiServer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication6.Server.Server;

public class ServerThread extends Thread{

    Socket client;
    DataOutputStream outClient;
    BufferedReader inClient;
    
    public ServerThread(Socket client) {
        
        this.client = client;
        
        try {
            
            outClient = new  DataOutputStream(client.getOutputStream());
            inClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
        } 
        catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        
        try {
            
            String msgUtente="Ciao a tutti";
            outClient.writeBytes(msgUtente+"\n");
            System.out.println("Msg inviato");
            String msgClient = inClient.readLine();
            System.out.println("Msg del client: "+msgClient);
            
        } 
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            outClient.close();
            inClient.close();
            System.out.println("Chiusura Socket vs Client");
            this.client.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }   
}
