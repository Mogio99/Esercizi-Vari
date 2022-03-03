
package javaapplication4;

import java.io.*;
import java.net.*;

public class SingleServer {
    private int type;
    private int Port;
    private ServerSocket Handler=null;
    private Socket connection=null;
    private String recived;
    private String tosend;
    private BufferedReader input;
    private DataOutputStream output;
    
    
    public SingleServer(int port,int type) throws IOException {
        this.type=type;
        this.Port=port;
        Handler=new ServerSocket(this.Port);
        if(this.type==1)
        {
            System.out.println("-.- Server Started");
        }
        connection=Handler.accept();
        if(this.type==1)
        {
            System.out.println("-.- Connection accepted connection from "+connection.getInetAddress());
        }
        Handler.close();
        input= new BufferedReader(new InputStreamReader(connection.getInputStream()));
        output= new DataOutputStream(connection.getOutputStream());
    }
    public String Listen() throws IOException{
        if(!this.connection.isClosed())
        {
             this.recived=this.input.readLine();
             if(this.type==1)
                {
                    System.out.println("-.- Message recived by the server");
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
           System.out.println("-.- Message send by the server"); 
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

};
