package pag.pkg146.n.pkg8.server;


import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ServerHandler extends Thread{
    private ServerSocket Server=null;
    private Socket temporarySocket=null;
    private List<ServerThread> Threads=new ArrayList();
    private int type=0;
        public ServerHandler(int port,int type) throws IOException
        {
            this.type=type;
            this.Server=new ServerSocket(port);
        }
        public void run()
        {
           
           try
            {               
               if(type==1)
                      {
                          System.out.println("-.- Server started");
                      }
                while(true)
                {
                     if(type==1)
                      {
                          System.out.println("-.- Server in attesa");
                      }
                      this.temporarySocket=Server.accept();
                      Threads.add(new ServerThread(this.temporarySocket,1));
                          Threads.get(Threads.size()-1).start();
                      
                      
                      if(type==1)
                      {
                          System.out.println("-.- nuova connessione n:"+Threads.size());
                      }                   
                }              
            }
            catch(Exception ex)
            {
                System.out.println("Errore");
            } 
        }
        public void Lettura(String area) throws IOException
        {
            String tmpMat="--";
            Double tmpValore=0.0;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            Calendar cal = Calendar.getInstance();
            Date date = new Date();
            String now=dateFormat.format(date);
            File file =new File("Resoconto"+now+".txt");
            file.createNewFile();
            
            List<String> contenuto=new ArrayList();
            for(int i=0;i<Threads.size();i++)
            {
                if(Threads.get(i).getArea().equals(area))
                {
                    Threads.get(i).Lettura();
                    tmpMat=Threads.get(i).getMatricola();
                    tmpValore=Threads.get(i).getValue();
                    contenuto.add("-- "+tmpMat+" "+tmpValore);
                }
            }
            Files.write(Paths.get("Resoconto"+now+".txt"),contenuto);
        }
}
