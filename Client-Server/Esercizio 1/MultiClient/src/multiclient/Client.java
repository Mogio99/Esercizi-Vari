/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiclient;

import java.io.*;
import java.net.*;

/**
 *
 * @author utente locale
 */
public class Client {
    Socket socket;
     private String nick; //Nickname
     private String  pw;  //password
      private String risultato; //Accesso consentito o negato
      private String result;
      private String richiesta; //Richiesta fatta al server
      private Boolean exit = false; //Ciclo per richiesta informazioni
      private Boolean retry = false;
    private DataInputStream inputDaServer;     //Input dal server
    private String nomeServer = "localhost"; //Nome server
    private int portaServer = 6969; //Porta server

    private DataOutputStream outputVersoServer; //Output al server
    private BufferedReader tastiera; //Scrittura da tastiera
    
    public Socket connetti() throws IOException{
        socket = new Socket(nomeServer,portaServer);                            //Crea socket per connettersi al server
        outputVersoServer = new DataOutputStream(socket.getOutputStream());     //Sin
        inputDaServer = new DataInputStream(socket.getInputStream());           //Ack
        System.out.println("Ciao, io sono il client!");                         //Client
        return socket;                                                          //Ritorna il proprio socket
    }
    public void comunica(){
        try{
             tastiera = new BufferedReader(new InputStreamReader(System.in)); // Input
             do{
             System.out.println("Inserire nickname : ");                     //Inserimento nickname
             nick = tastiera.readLine(); 
              System.out.println("Inserire password : ");                    //Inserimento password
             pw = tastiera.readLine();
              outputVersoServer.writeBytes(nick + '\n');                    //Invio nickname
              outputVersoServer.writeBytes(pw + '\n');                      //Invio password
              risultato = inputDaServer.readLine(); 
              System.out.println(risultato);   //Risultato check
              if(risultato.equals("Consentito"))                               //Se accesso è consentito entra nel loop
              {
                  System.out.println("Entro");   
                  while(exit==false)                                       //Loop fino a EXIT
                  {
                     System.out.println("Inserire RICHIESTA : \n");
                      System.out.println("Disponibili : \n ORA \n GIORNO \n LOG \n QUIT \n Scrivi : ");
                     richiesta = tastiera.readLine();
                     outputVersoServer.writeBytes(richiesta + '\n');
                     result=inputDaServer.readLine();
                      System.out.println("Risposta : " + result + "\n");
                     if(richiesta.equals("QUIT"))
                     {
                         exit=true;
                     }
                  }
                  socket.close();
              }
              else
              {
                  System.out.println("TestErrato");   
                  retry=true;
              }
             }while(retry);
        }
        catch(Exception e){
        System.out.println("Errore di comunicazione");
        }
    }
}
