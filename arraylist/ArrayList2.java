package tareaopenbootcamp.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList2 {

    public static void main(String[] args) {


        //ESTE MÉTODO FUE EL QUE SE ME OCURRIÓ PARA RESOLVER ESTE EJERCICIO
        //PERO AL PARECER NO ES EL MÁS ADECUADO, ASÍ QUE INVESTIGUÉ Y DESARROLLÉ UNO NUEVO
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i = 1; i<=10; i++){
            nums.add(i);
        }

        for(int i = 0 ; i < nums.size(); i++){
            if(nums.get(i)%2 == 0){
                nums.remove(i);
            }else{
                System.out.println(nums.get(i));
            }
        }


        // EN ESTE MÉTODO HAGO USO DE UN OBJETO DE LA CLASE ITERATOR PARA MANIPULAR EL ARRAYLIST EN EL CICLO.

        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i = 1; i<=10; i++){
            numbers.add(i);
        }

        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            Integer num = it.next();
            if (num % 2 == 0) {
                it.remove();
            } else {
                System.out.println(numbers);
            }
        }

    }
}







