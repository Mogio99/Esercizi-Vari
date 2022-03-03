/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4.Multiserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mogionia
 */
public class ServerParlante extends Thread{

    BufferedReader tastiera;
    LinkedList<BufferedReader> Lista = new LinkedList();
    
    @Override
    public void run() {
        try {
            
            System.out.println("Inserisci un msg: ");
            String msg = tastiera.readLine();
            for(int i=0;i<Lista.size();i++){
                msg.Lista.get(i);            
            }
            
        } 
        
        catch (IOException ex) {
            Logger.getLogger(ServerParlante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void aggiorna(DataOutputStream TemporaryBuffered) {
        Lista.add(TemporaryBuffered); 

    }
    
}
