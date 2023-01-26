package tareaopenbootcamp.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayList1 {

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();
        words.add("Elemento 1");
        words.add("Elemento 2");
        words.add("Elemento 3");
        words.add("Elemento 4");

        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();


        //Primer método para copiar ArrayList en una LinkedList: Agregando elemento a elemento
        for(String word: words){ list1.add(word); }

        //Segundo método para copiar ArrayList en una LinkedList: Agregando todos los elementos a la vez
        list2.addAll(words);

        //También se puede instanciar directamente y enviar el arraylist como parámetro al constructor de la linkedlist
        LinkedList<String> list3 = new LinkedList<>(words);

        //RECORRIDO DE AMBAS LISTAS:
        for(int i = 0; i<words.size(); i++){
            System.out.println("Valor Array: " + words.get(i) + " Valor Linked: " + list1.get(i));
        }

        for(int i = 0; i<words.size(); i++){
            System.out.println("Valor Array: " + words.get(i) + " Valor Linked: " + list2.get(i));
        }

        for(int i = 0; i<words.size(); i++){
            System.out.println("Valor Array: " + words.get(i) + " Valor Linked: " + list3.get(i));
        }



    }
}
