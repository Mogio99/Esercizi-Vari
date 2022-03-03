/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiclient;

/**
 *
 * @author utente locale
 */
public class JavaSocket_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client c = new Client();
        try{
        c.connetti();
        }
        catch(Exception e){
        System.out.println("errore di connessione");
        }
        c.comunica();
    }
    
}