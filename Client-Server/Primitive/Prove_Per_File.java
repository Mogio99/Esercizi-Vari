package javaapplication6;

import java.io.*;
public class Prove_Per_File {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File mioFile = new File("mioFile.txt");
        
        try{
            //creazione
            if(!mioFile.exists())
                mioFile.createNewFile();
            
            //scrittura
            FileWriter mioFileWriter = new FileWriter(mioFile);
            
            CharSequence a = "Pippo fa la cacca";
            mioFileWriter.write("Ciao \n");
            mioFileWriter.append(a);
            
            mioFileWriter.close();
            
            //lettura
            FileReader mioFileReader = new FileReader(mioFile);
            BufferedReader mioReader = new BufferedReader(mioFileReader);
            System.out.println(mioReader);
            
            int i=0;
            String miaRiga="";
            
            while(miaRiga != null){ //oppure (miaRiga = mioReader.readLine()) != null
                i++;
                miaRiga = mioReader.readLine();
                System.out.println("Mia riga "+i+" "+miaRiga);
            }
            
            mioFileReader.close();
        }
        catch(Exception ex){
            System.out.println("Errore di pippo");
        }
    }
    
}
