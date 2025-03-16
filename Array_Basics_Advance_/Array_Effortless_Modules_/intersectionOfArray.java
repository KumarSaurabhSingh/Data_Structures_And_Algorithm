import java.util.ArrayList;
import java.util.Scanner;

public class intersectionOfArray {

    static ArrayList intersectionOfArray(int[] arr1, int[] arr2){

        int[] visit = new int[arr2.length];
        ArrayList<Integer> intersection = new ArrayList<>();

        for(int i=0; i<arr1.length; i++){

            for(int j=0; j<arr2.length; j++){

                if(arr1[i] ==arr2[j] && visit[j] ==0){
                    intersection.add(arr2[j]);
                    visit[j] =1;
                }

                if(j>i){
                    break;
                }
            }
        }

        return intersection;
    }
    

    public static void main(String[] args){

        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //Taking input in the array
        int[] array1 = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array1[i] = input.nextInt();
        }

        int arraySize2;
        arraySize2 = input.nextInt();

        //Taking input in the array
        int[] array2 = new int[arraySize2];
        for(int i=0; i<arraySize2; i++){
            array2[i] = input.nextInt();
        }

        //Inserting result in ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        result = intersectionOfArray(array1, array2);

        for(int Iterator : result){
            System.out.print(Iterator + "  ");
        }
    }
}
