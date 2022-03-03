package multiserver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerHandler extends Thread{
    private ServerSocket Server=null;
    private Socket temporarySocket=null;
    private List<ServerThread> Threads=new ArrayList();
    private int type=0;
    private int count=0;
      private BufferedReader tastiera;
    private Boolean keep=true;
        public ServerHandler(int port,int type) throws IOException
        {
            
            this.type=type;
            this.Server=new ServerSocket(port);
            
        }
        public void Close() throws IOException
        {
            for(int i=0;i<Threads.size();i++)
            {
                Threads.get(i).Close();               
            }
            this.keep=false;
        }
        public void run()
        {
           
           try
            {               
               if(this.type==1)
                      {
                          System.out.println("-.- Server started");
                      }
                while(keep)
                {
                     if(this.type==1)
                      {
                          System.out.println("-.- Server in attesa");
                      }
                     
                      this.temporarySocket=Server.accept();
                      Threads.add(new ServerThread(this.temporarySocket,this.type));
                      Threads.get(Threads.size()-1).start();
                      if(this.type==1)
                      {
                          System.out.println("-.- nuova connessione n:"+Threads.size());
                      }
                      count++;
                      if(count==3)
                      {
                     this.keep=true;
                    Threads.get(2).join();
                    elabora();
                    Server.close();
                      }
                    }
            }   
            catch(Exception ex)
            {
                System.out.println("Errore Handler");
            } 
        }
        public void elabora() throws IOException
        {
             tastiera = new BufferedReader(new InputStreamReader(System.in)); // Input6
            String p = "1";
            String s = "2";
            String t = "3";
            for(int j=0;j<Threads.size();j++)
            Threads.get(j).check(p,s,t);    
        }
        }
