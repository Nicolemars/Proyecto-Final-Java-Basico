package tareaopenbootcamp.inputandprint;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class InputAndPrint {

    public static void main(String[] args) {

        try{
            cloneFile("fileIn", "fileOut");
        }catch(IOException e){
            System.out.println("No se pudo realizar la copia de ficheros");
        }


    }

    public static void cloneFile(String fileIn, String fileOut) throws IOException{

        InputStream in = null;
        PrintStream out = null;

        try{

            in = new FileInputStream(fileIn);
            out = new PrintStream(fileOut);

            int bt;
            while((bt = in.read()) != -1){

                out.write(bt);
            }

        }finally {

            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }

        }

    }

}
