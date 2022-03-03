/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6.Server;

/**
 *
 * @author mogionia
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Server s = new Server();
        s.instanzia();
        s.comunica();
        
    }
    
}
