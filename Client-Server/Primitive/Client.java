
package pag.pkg140.es.pkg1.client;
import java.io.*;
import java.net.*;

public class Client {
    private int type;
    private int port;
    private String IP;
    private Socket connection=null;
     private String recived;
    private String tosend;
    private BufferedReader input;
    private DataOutputStream output;
    
    public Client(String IP,int port,int type) throws IOException
    {
        this.type=type;
        if(this.type==1)
        {
            System.out.println("-.- Connection Started");
        }
        this.port=port;
        this.IP=IP;
        connection=new Socket(IP,port);
          if(this.type==1)
        {
            System.out.println("-.- Connected sucseffuly to "+this.IP);
        }
        input= new BufferedReader(new InputStreamReader(connection.getInputStream()));
        output= new DataOutputStream(connection.getOutputStream());
    }
    public String Listen() throws IOException{
        if(!this.connection.isClosed())
        {
             this.recived=this.input.readLine();
               if(this.type==1)
                {
                    System.out.println("-.- Message recived from the server");
                }
            return this.recived;
        }
       return null;
    }
    public void Send(String tosend) throws IOException{
        if(!this.connection.isClosed())
        {
              this.tosend=tosend;
        output.writeBytes(this.tosend+'\n');
          if(this.type==1)
            {
                System.out.println("-.- Message send by the client");
            }
         
        }
      
    }
    public void Adios() throws IOException
    {
         if(!this.connection.isClosed())
        {
                this.connection.close();
                  if(this.type==1)
                    {
                        System.out.println("-.- Connection closed");
                    }
                
        }
         else
         {
               if(this.type==1)
                {
                    System.out.println("-.- Connection already closed");
                }
             
         }
    
    }
    public boolean StillHere(){
        boolean Response;
        if(this.connection.isClosed())
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}
