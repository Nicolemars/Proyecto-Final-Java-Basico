package tareaopenbootcamp.programafinal;
import java.io.IOException;
import java.util.Scanner;


/**
 * @author Omar Piedrahita Tylermars666
 * Este programa hace uso de conceptos como HashMap, ArrayList, InputStream, PrintStream, Interfaces y manejo de
 * Excepciones
 * Su función es almacenar ficheros con id en una pseudo base de datos que es un HashMap.
 * El usuario tiene la posibilidad de añadir, editar, ver, eliminar, crear backup e imprimir contenido de los
 * ficheros
 *
 * Pude crear más clases y refactorizar aún más el código, verdad?
 * Supongo que es una aptitud que iré desarrollando en el proceso
 */
public class FinalProgram {

    static FicherosCRUD crud = new FicherosCRUDImpl();

    public static void main(String[] args) {

        int option;
        boolean confirm;
        String route;
        String key;
        Scanner keyBoard = new Scanner(System.in);

        do{

            System.out.println("""
                    Ingrese el número correspondiente a lo que desea hacer:\s
                    1. Añadir un fichero\s
                    2. Editar un fichero existente\s
                    3. Ver la ruta de un fichero existente\s
                    4. Eliminar un fichero existente\s
                    5. Crear un Backup sobre un fichero existente\s
                    6. Imprimir en consola el contenido de un fichero existente\s
                    7. Salir""");

            option = keyBoard.nextInt();
            switch (option) {
                case 1 -> {
                    key = getEditorKey("Indique el código para el fichero");
                    route = getRoute("Indique la ruta del fichero");
                    confirm = crud.addFile(key, route);
                    crud.modifiedSuccessfully(confirm,"add");
                }
                case 2 -> {
                    key = getEditorKey("Indique el código del fichero");
                    route = getRoute("Indique una nueva ruta para el fichero");
                    confirm = crud.editFile(key, route);
                    crud.modifiedSuccessfully(confirm, "edit");
                    System.out.println("Ediciones realizadas: " + crud.toString());
                }
                case 3 -> {
                    key = getEditorKey("Indique el código del fichero");
                    route = crud.findFile(key);
                    System.out.println("La ruta del fichero correspondiente al código " + key + " es: " + route);

                }
                case 4 -> {
                    key = getEditorKey("Indique el código del fichero a eliminar");
                    confirm = crud.deleteFile(key);
                    crud.modifiedSuccessfully(confirm, "delete");
                }
                case 5 -> {
                    try {
                        key = getEditorKey("Indique el código del fichero");
                        confirm = crud.createBackUp(key);
                        crud.modifiedSuccessfully(confirm, "backup");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                case 6 -> {
                    try {
                        key = getEditorKey("Indique el código del fichero");
                        crud.printContent(key);
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
                case 7 -> System.out.println("Adiós!");
                default -> System.out.println("Opción incorrecta, elija una opción válida");
            }
        }while (option != 7);

        keyBoard.close();

    }

    //Pedir código de editor de fichero
    public static String getEditorKey(String message){
        Scanner board = new Scanner(System.in);
        System.out.println(message);
        return board.nextLine();
    }
    // Pedir ruta de fichero
    public static String getRoute(String message){
        Scanner board = new Scanner(System.in);
        System.out.println(message);
        return board.nextLine();
    }

}
