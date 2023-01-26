package tareaopenbootcamp.arrays;

public class ArrayBidimensional {

    public static void main(String[] args) {

        int [][] numbersArray = {
                {10, 20, 30, 40, 50},
                {100, 200, 300, 400, 500},
                {1000, 2000, 3000, 4000, 5000},
                {10000, 20000, 30000, 40000, 50000}
        };

        for(int i = 0; i<numbersArray.length; i++){
            for (int j = 0; j<numbersArray[i].length; j++){
                System.out.println("Estás en la posición:" +
                        " (" + i + ", " + j + ")" + " y su valor es: " + numbersArray[i][j] );
            }
        }

    }
}
