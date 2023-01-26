package tareaopenbootcamp.programafinal;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FicherosCRUDImpl implements FicherosCRUD{

    ArrayList<String> edits = new ArrayList<>(); //Lleva el registro de las modificaciones
    HashMap<String, String> pseudoBaseDatos = new HashMap<>(); //Código y Ruta del fichero
    HashMap<String, PrintStream> backUp = new HashMap<>(); //Donde se hace copia de fichero

   /*Se agrega el fichero en caso de no existir
   * Si la clave ya existe dentro del hashmap, se retorna un false*/
    @Override
    public boolean addFile(String key, String route) {
        boolean addedFile = inputValidate(key);

        if(!addedFile){
            pseudoBaseDatos.put(key,route);
        }

        return !addedFile;
    }


   /* Si la clave ya existe, se reemplazan con los datos dados
   * en caso contrario se retorna un false*/
    @Override
    public boolean editFile(String key, String newRoute) {
        boolean editedFile = inputValidate(key);

        if(editedFile) {
            pseudoBaseDatos.replace(key, newRoute);
            edits.add(key); //Arraylist donde se agrega el código de quien hizo el edit
        }

        return editedFile;
    }


    /*Imprime el valor correspondiente a la clave dada
    En caso contrario dice que el fichero no ha sido
    encontrado*/
    @Override
    public String findFile(String key) {

        if(inputValidate(key)){
            return pseudoBaseDatos.get(key);
        }

        return "La ruta del fichero no ha sido encontrada";

    }


    /*Si la clave existe, se elimina el elemento del hashmap
    en caso contrario, se retorna un false*/
    @Override
    public boolean deleteFile(String key) {

        boolean deletedFile = inputValidate(key);

        if(deletedFile){
            pseudoBaseDatos.remove(key);
        }

        return deletedFile;
    }


    //Copia el fichero contenido en un FileInputStream a un PrintStream
    @Override
    public boolean createBackUp(String key) throws IOException{

        boolean fileExist = inputValidate(key);
        InputStream in = null;
        PrintStream out = null;

        if(fileExist){

            try{
                in = new FileInputStream(pseudoBaseDatos.get(key));
                out = new PrintStream("backUpFile: " + key);
                int c;
                while((c = in.read()) != -1){
                    out.write(c);
                }
                backUp.put(key,out);

            }finally {
                if(in!=null){
                    in.close();
                }
                if(out!=null){
                    out.close();
                }
            }
        }

        return fileExist;
    }


    //Imprime por consola el contenido del fichero
    @Override
    public void printContent(String key) throws IOException{

        if(inputValidate(key)){

            try(InputStream in = new FileInputStream(pseudoBaseDatos.get(key))) {

                int c= in.read();
                while(c != -1){

                    System.out.print((char)c);
                    c = in.read();
                }
            }
        }

        System.out.println("No existe ese fichero");
    }


    //Verifica si la clave Key ya existe en el hashmap
    public boolean inputValidate(String key){
        return pseudoBaseDatos.containsKey(key);
    }


    //Solo imprime ArrayList que contiene los códigos de los edits realizados
    @Override
    public String toString() {
        return "código de editor: " + edits;
    }


    //Imprime mensaje si la modificación fue satisfactoria o no
    public void modifiedSuccessfully(boolean isModified, String typeMessage){

        String messageTrue = "";
        String messageFalse = "";

        switch (typeMessage) {
            case "add" -> {
                messageTrue = "Fichero añadido con éxito";
                messageFalse = "Ya existe un fichero con el código indicado";
            }
            case "edit" -> {
                messageTrue = "Fichero editado con éxito";
                messageFalse = "No existe ningún fichero con el código indicado";
            }
            case "delete" -> {
                messageTrue = "Fichero eliminado con éxito";
                messageFalse = "No existe ningún fichero con el código indicado";
            }
            case "backup" -> {
                messageTrue = "Backup creado con éxito";
                messageFalse = "Fallo en la creación del Backup";
            }
        }
        if(isModified){
            System.out.println(messageTrue);
        }else{
            System.out.println(messageFalse);
        }
    }


}

