/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4.Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author mogionia
 */
public class Client {
    String nomeServer;
    int portaServer;
    Socket s;
    DataOutputStream outServer;
    BufferedReader inServer;
    BufferedReader tastiera;
                    
    public Client(String nomeServer, int portaServer) {
        this.nomeServer = nomeServer;
        this.portaServer = portaServer;
    }
    
    public void connetti(){
        
        try{
            s = new Socket(nomeServer,portaServer);
            outServer = new  DataOutputStream(s.getOutputStream());
            inServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Connessione avvenuta");
        }
        catch(UnknownHostException e){
            System.out.println("Connessione fallita");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }
    
    public void comunica(){
        
        try{
            
            String msgServer = inServer.readLine();
            System.out.println("Il messaggio ricevuto dal Server e': "+msgServer);
            String msgUtente = tastiera.readLine();
            
            outServer.writeBytes(msgServer+" "+ msgUtente +'\n');
            s.close();
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
