package server.multiplo;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ServerThread extends Thread{
    private Socket Client=null;
    private String StringaRicevuta=null;
    private String StringaDainviare=null;
    private BufferedReader input;
    private DataOutputStream output;
    int type=0;
        public ServerThread(Socket socket,int type) 
        {
            this.type=type;
            try{
                this.Client=socket;
                this.input=new BufferedReader(new InputStreamReader(this.Client.getInputStream()));
                this.output= new DataOutputStream(this.Client.getOutputStream());
            }
            catch(Exception ex)
            {
                System.out.println("Erorre");
            }
        }    
        public String Listen() throws IOException{
        if(!this.Client.isClosed())
        {
             this.StringaRicevuta=this.input.readLine();
               if(this.type==1)
                {
                    System.out.println("-.- Message recived from the server");
                }
            return this.StringaRicevuta;
        }
       return null;
    }
    public void Send(String tosend) throws IOException{
        if(!this.Client.isClosed())
        {
              this.StringaDainviare=tosend;
        output.writeBytes(this.StringaDainviare+'\n');
          if(this.type==1)
            {
                System.out.println("-.- Message sent by the client");
            }         
        }      
    }
    public void Close() throws IOException
    {
        this.Client.close();
    }
    public void run()
        {          
        try { 
            
            
        } 
        catch (Exception ex) {
           
            
        }
        }
}
