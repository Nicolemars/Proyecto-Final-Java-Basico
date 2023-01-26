package tareaopenbootcamp.excepciones;

import java.util.Scanner;

public class Excepciones {

    public static void main(String[] args) {

        try{
            Scanner keyBoard = new Scanner(System.in);
            System.out.println("Ingrese dos números para dividir");
            int a = keyBoard.nextInt();
            int b = keyBoard.nextInt();
            dividePorCero(a,b);
            keyBoard.close();
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Demo de código");
        }

    }

    public static void dividePorCero(int a, int b) throws ArithmeticException{

        if(b==0){
            throw new ArithmeticException("Esto no puede hacerse");
        }else{
            System.out.println("La división es: " + (a/b));
        }

    }

}
