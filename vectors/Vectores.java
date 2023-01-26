package tareaopenbootcamp.vectors;

import java.util.Vector;

public class Vectores {

    public static void main(String[] args) {

        Vector<String> words = new Vector<>();

        words.add("Primer elemento");
        words.add("Segundo elemento");
        words.add("Tercer elemento");
        words.add("Cuarto elemento");
        words.add("Quinto elemento");

        /*Al eliminar el elemento de índice 1, el nuevo Vector queda solo con 4 elementos, y el elemento siguiente
        que posee el índice 2, es el que antes tenía el índice 3 */
        words.remove(1);
        words.remove(2);

        System.out.println(words);

        /*El problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos para ser
        añadidos, radica en que el vector hace un resizing cada que hay un overflow de su capacidad inicial, esto es
        ineficiente en términos de rendimiento, ya que debe crearse un nuevo array, y copiarse los datos anteriores
        además de que el Vector duplica su capacidad, a diferencia del ArrayList que solo aumenta su capacidad en un
        50%*/

    }
}
