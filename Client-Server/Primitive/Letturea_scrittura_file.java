/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letturea_scrittura_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author spadaro
 */
public class Letturea_scrittura_file {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MioGestoreFile file = new MioGestoreFile("mioFile.txt");
        
        System.out.print(file.leggiInteroFile());
        
        /*
        File mioFile = new File("mioFile.txt");
        try{
        if( !mioFile.exists() )
            mioFile.createNewFile();
        
        FileWriter mioFileWriter = new FileWriter(mioFile);
        mioFileWriter.write("Ciao!");
        CharSequence append = "W la pappa col pomodoro";
        mioFileWriter.append(append);
        mioFileWriter.close();
        
        FileReader mioFileReader = new FileReader(mioFile);
        BufferedReader mioReader = new BufferedReader(mioFileReader);
        //System.out.println(mioReader);
        int i = 0;
        String miaRiga = "";
        while((miaRiga = mioReader.readLine()) != null){
            i++;
            System.out.println("miaRiga"+i+" = "+miaRiga);
        }
        
                mioFileReader.close();
        
        
        }
        catch(Exception e){
            System.out.println("Errore generico");
        }
        */
    }
    
}
