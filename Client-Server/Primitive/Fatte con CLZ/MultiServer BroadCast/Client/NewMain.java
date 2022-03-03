/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4.Client;

import java.io.IOException;

/**
 *
 * @author mogionia
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        Client c1 = new Client("localhost",6789);
        c1.connetti();
        c1.comunica();
    }
    
}
