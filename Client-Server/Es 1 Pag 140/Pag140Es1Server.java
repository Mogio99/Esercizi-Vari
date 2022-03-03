
package pag.pkg140.es.pkg1;
import java.io.*;

public class Pag140Es1Server {
    public static void main(String[] args) {
        try{
                SingleServer Conn=new SingleServer(6789,0);
                int op1,op2,result;
                String oper;
                op1=Integer.parseInt(Conn.Listen());
                op2=Integer.parseInt(Conn.Listen());
                oper=Conn.Listen();
                switch(oper)
                {
                    case "+":
                        result=op1+op2;
                        break;
                    case "-":
                        result=op1-op2;
                        break;
                    case "/":
                        result=op1/op2;
                        break;
                    case "*":
                        result=op1*op2;
                        break;
                    default:
                        result=0;
                        break;
                }
                String tosend="Il risultato e' "+result;
                Conn.Send(tosend);
                Conn.Adios();
        }
        catch(IOException ex)
         {
             System.out.println("Error");  
         }
        
        
    }
    
}
