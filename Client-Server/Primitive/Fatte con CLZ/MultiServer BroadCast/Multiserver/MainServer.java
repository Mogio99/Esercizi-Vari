package javaapplication4.Multiserver;

public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MultiServer s = new MultiServer();
        s.avvio();
        ServerParlante Grillo = new ServerParlante();
        
        
    }
    
}
