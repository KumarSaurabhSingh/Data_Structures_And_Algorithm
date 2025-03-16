import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class nextPermutations {


    static void reverse(int[] array, int low, int high){
        while(low<high){
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            low++;
            high--;
        }
    }

    static void nextPermutations(int[] array){

        //finding the dip in the array - step 1
        int n = array.length;
        int index =-1;
        for(int i =n-2; i>0; i--){
            if(array[i] < array[i+1]){
                index = i;
                break;
            }
        }
        //System.out.println(array[index]);

        // If break point does not exist:
        if (index == -1) {
            // reverse the whole array:
            reverse(array, 0, n);
            printArray(array);
        }

        //Step -2 : finding the just largest but smallest number and swap it with index value
        for(int i=n-1; i>index; i--){
            if(array[i] > array[index]){
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
                break;
            }
        }
        //Now reverse the remainig array
        reverse(array, index+1, n-1);

    }


    //Printing the array
    static void printArray(int[] array){

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    

    public static void main(String[] args){
        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //Taking input in the array
        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        nextPermutations(array);
        printArray(array);


        // reverse(array, 0, arraySize-1);
        // printArray(array);
    }
}
