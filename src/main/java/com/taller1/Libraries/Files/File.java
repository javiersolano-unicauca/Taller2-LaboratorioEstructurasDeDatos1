package com.taller1.Libraries.Files;

import com.taller1.Libraries.Consoles.Console;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author javiersolanop
 */
public class File {
    
    // Properties:
    private String atrPath = System.getProperty("user.dir");
    private FileInputStream atrFileInput;
    private FileOutputStream atrFileOutput;

    // Constructors:
    public File(String prmPath)
    {
        atrPath += prmPath;
    }

    // Methods:

    /**
     *  Metodo para exportar un archivo en formato 'txt',
     *  adicionando un salto de linea a cada fila del arreglo.
     * 
     *  @param prmFileName El nombre que debe tener el archivo
     *  @param prmContent El contenido del archivo
     *  @return 'true' si se exporta. 'false' si no.
     */
    public boolean exportTxtWithLn(String prmFileName, String[] prmContent)
    {
        try{

            atrFileOutput = new FileOutputStream(atrPath+"\\"+prmFileName+".txt");
            String[] varContent = prmContent.clone();

            for(String str: varContent){
                str = str.concat("\n");
                atrFileOutput.write(str.getBytes(StandardCharsets.UTF_8));
            }
            atrFileOutput.flush();
            atrFileOutput.close();
            return true;

        }catch(IOException e){
            Console.printMessage("No se puede exportar el archivo!");
            return false;
        }
    }
    
    /**
     *  Metodo para exportar un archivo en formato 'txt'
     * 
     *  @param prmFileName El nombre que debe tener el archivo
     *  @param prmContent El contenido del archivo
     *  @return 'true' si se exporta. 'false' si no.
     */
    public boolean exportTxt(String prmFileName, String[] prmContent)
    {
        try{

            atrFileOutput = new FileOutputStream(atrPath+"\\"+prmFileName+".txt");
            String[] varContent = prmContent.clone();

            for(String str: varContent)
                atrFileOutput.write(str.getBytes(StandardCharsets.UTF_8));
            
            atrFileOutput.flush();
            atrFileOutput.close();
            return true;

        }catch(IOException e){
            Console.printMessage("No se puede exportar el archivo!");
            return false;
        }
    }

    /**
     *  Metodo para importar un archivo en formato 'txt'
     * 
     *  @param prmFileName El nombre del archivo
     *  @return El arreglo de filas del archivo o null si no se puede importar
     */
    public String[] importTxt(String prmFileName)
    {
        try{

            atrFileInput = new FileInputStream(atrPath+"\\"+prmFileName+".txt");
            byte[] arrBytes = new byte[atrFileInput.available()];
            DataInputStream objDataInputStream = new DataInputStream(atrFileInput);
            objDataInputStream.readFully(arrBytes);
            atrFileInput.close();
            
            if(arrBytes.length > 0){
                
                byte[][] mtrBytes = Byte.splitln(arrBytes);
                String[] arrRows;

                if(mtrBytes != null){
                   
                    int varSize = mtrBytes.length;
                    arrRows = new String[varSize];

                    for(int i = 0; i < varSize; i++)
                        arrRows[i] = Byte.parseByteToString(mtrBytes[i]);
                }else{
                    arrRows = new String[1];
                    arrRows[0] = Byte.parseByteToString(arrBytes).replace("\n", "");
                }

                return arrRows;
            }

        }catch(IOException e){
            Console.printMessage("No se puede importar el archivo!");
        }
        return null;
    }
}