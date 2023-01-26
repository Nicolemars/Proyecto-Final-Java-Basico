package tareaopenbootcamp.cadenainvertida;
import java.util.Scanner;

/**
 * @author Omar Piedrahita - Tylermars666
 */
public class reverseString {

    public static void main(String[] args) {

        String reverseText1 = reverseConcatenation();
        String reverseText2 = reverseStringBuilder();

        System.out.println("Cadena invertida con método concatenación: " + reverseText1);
        System.out.println("Cadena invertida con método StringBuilder: " + reverseText2);

    }

    /**
     * @Description Esta función solicita texto y lo invierte a través de un loop usando el método append de la clase
     * StringBuilder
     * @return textoInvertido.toString
     */
    private static String reverseStringBuilder() {

        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Escriba un texto");
        String text = keyBoard.nextLine();

        StringBuilder reverseText = new StringBuilder();

        for(int i = text.length()-1 ; i>=0 ; i--){

            reverseText.append(text.charAt(i));
        }
        keyBoard.close();
        return reverseText.toString();
    }

    /**
     * @Description Esta función solicita texto y lo invierte a través de un loop usando concatenación de caracteres
     * en una variable String
     * @return textoInvertido
     */
    private static String reverseConcatenation() {

        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Escriba un texto");
        String text = keyBoard.nextLine();
        String reverseText = "";

        for(int i = text.length()-1; i>=0;i--){
            reverseText = reverseText + text.charAt(i);
        }
        keyBoard.close();
        return reverseText;
    }

}
