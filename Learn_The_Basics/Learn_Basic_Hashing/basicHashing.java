import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
//Checking the frequency of the numbers in the array
public class basicHashing {
    
    static void basicHashing(int arraySize, int arr[]){

        HashMap<Integer, Integer> element = new HashMap<>();

        for (int i=0; i<arraySize; i++){
            if(element.containsKey(arr[i])){
                element.put(arr[i], element.get(arr[i])+1);
            }

            else{
                element.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : element.entrySet()){

            System.out.println(entry.getKey() + " " + entry.getValue());
            
        }

    }
    public static void main(String[] args){

        int sizeArray;
        Scanner input = new Scanner(System.in);
        sizeArray = input.nextInt();

        int[] array = new int[sizeArray];

        for(int i=0; i<sizeArray; i++){
            array[i] = input.nextInt();
        }

        basicHashing(sizeArray, array);

    }
}
