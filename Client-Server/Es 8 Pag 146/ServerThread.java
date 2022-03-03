package pag.pkg146.n.pkg8.server;


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
    private String area;
    private String matricola=null;
    private Double valore=0.0;
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
    public void Lettura()
    {
        try{
                Send("--Lettura--");
                this.matricola=Listen();
                this.valore=Double.parseDouble(Listen());
        }
        catch (Exception ex) {
            System.out.println("errore");
        }    
    }
    public String getMatricola()
    {
        return this.matricola;
    }
    public Double getValue()
    {
        return this.valore;
    }
    public String getArea()
    {
        return this.area;
    }
    public void run()
        {          
        try { 
            
            this.area=Listen();
        } 
        catch (Exception ex) {
            System.out.println("errore");
        }
        }
}
