package multiserver;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ServerThread extends Thread{
    private Socket Client=null;
    private String StringaRicevuta=null;
    private String StringaDainviare=null;
     private String nick;
     private String  pw;
     private String result;
      private String s;
      private String var = "";
      private String msg="";
      private char nextc;
      private int next;
      private Boolean nickfind=false;
      private Boolean pwfind=false;
      private int count=0;
    private BufferedReader input;
    private DataOutputStream output;
    private BufferedReader tastiera;
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
                System.out.println("out");
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
            try
            {
           do{
           nick=Listen();
           pw=Listen();
           System.out.println(nick +';' + pw);
               nickfind=false;
               pwfind=false;
               var="";
                FileReader f = new FileReader("C:\\Users\\pettinatokevin\\Documents\\NetBeansProjects\\MultiServer\\src\\multiserver\\utentiRegistrati.txt");
              
             do {
                next = f.read(); // legge il prossimo carattere
                nextc= (char) next;
                if (next != -1) { // se non e' finito il file
                     nextc = (char) next;
                    if(nextc==';')
                    {
                        count++;
                        if(count==2)
                        {
                            count=0;
                        }
                         System.out.println(nick);
                         System.out.println(pw);
                         System.out.println(var);
                    if(var.equals(nick))
                    {
                        nickfind=true;
                         System.out.println("Trovato Nick");
                    }
                    if(var.equals(pw))
                            {
                                 System.out.println("Trovata Pw");
                                pwfind=true;
                            }
                    var="";
                    }
                    else if(nextc=='\n')
                    {
                         System.out.println("Nuova Riga");
                        if(nickfind==true && pwfind==true)
                        {
                            next=-1;
                        }
                        else
                        {
                        nickfind=false;
                        pwfind=false;
                        var="";
                        }
                    }
                    else
                    var= var + nextc;
                }
            } while (next != -1);  
             if(nickfind==true && pwfind==true)
             {
                 result="Consentito";
                 System.out.println(result + '\n');
                 f.close();
             }
             else
             {
                 result="CampiErrati";
                 System.out.println(result);
                 f.close();
             }
             Send(result);
           }while(result!="Consentito");
             if(result=="Consentito")
             {
                 do
                 {
                   msg=Listen();
                   System.out.println(msg);
                   if(msg.equals("ORA"))
                   {
                       System.out.println("ORA");
                       Send("ORA");
                   }
                   if(msg.equals("GIORNO"))
                   {
                       System.out.println("GIORNO");
                       Send("GIORNO");
                   }
                       if(msg.equals("LOG"))
                       {
                       System.out.println("LOG");
                       Send("LOG");
                       }
                 }while(!msg.equals("QUIT"));
                 if(msg.equals("QUIT"))
                 {
                     Client.close();
                 }
             }
            } 
        catch (Exception ex) {
           ex.printStackTrace();
            
        }
        }
    public void check(String p , String s , String t) throws IOException
    {
        
    }
}
