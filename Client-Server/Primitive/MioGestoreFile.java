/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letturea_scrittura_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author spadaro
 */
public class MioGestoreFile {
    File mioFile;

    public MioGestoreFile(String pathMioFile) {
        this.mioFile = new File(pathMioFile);
        try{
        if( !mioFile.exists() )
            mioFile.createNewFile();
        }catch(Exception e){System.out.println("Errore generico");}
    }
       
    public String leggiInteroFile(){
        String miaStringa = "";
        try{
            FileReader mioFileReader = new FileReader(mioFile);
            BufferedReader mioReader = new BufferedReader(mioFileReader);
            String miaRiga = "";
            while((miaRiga = mioReader.readLine()) != null){
                miaStringa += miaRiga+"\n";
            }
            mioFileReader.close();
        }catch(Exception e){System.out.println("Errore generico");}
        return miaStringa;
    }
    
}
