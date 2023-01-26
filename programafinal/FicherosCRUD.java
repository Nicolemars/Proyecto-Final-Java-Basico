package tareaopenbootcamp.programafinal;

import java.io.IOException;

public interface FicherosCRUD {

    boolean addFile(String key, String route);
    boolean editFile(String key, String newRoute);
    String findFile(String key);
    boolean deleteFile(String key);
    boolean createBackUp(String key) throws IOException;//COPIAR EL FILEINPUT A UN PRINTINPUT
    void printContent(String key) throws IOException; //IMPRIME EN CONSOLA EL CONTENIDO DEL FICHERO
    void modifiedSuccessfully(boolean isModified, String typeMessage);

}
