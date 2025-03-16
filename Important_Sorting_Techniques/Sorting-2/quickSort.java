import java.util.ArrayList;
import java.util.Scanner;

//Time Complexity of the Quick will be O(N * LogN)
//The space Complexity will be O(1)

public class quickSort {

    static void quickSort(int[] array, int low, int high){

        if(low>high){
            return;
        }

        int midIndex = pivotIndex(array, low, high);

        //System.out.println(midIndex);

        quickSort(array, low, midIndex-1);

        quickSort(array, midIndex+1, high);

    }

    static int pivotIndex(int[] arr, int low, int high){
        ArrayList<Integer> element = new ArrayList<>();

        int pivot = arr[low];
        int i=low;
        int j=high;

        while(i<j){

            while(arr[i] <= pivot && i<=high-1){
                i++;
            }

            while (arr[j] > pivot && j>=low+1){
                j--;
            }

            if(i<j){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

            int temp = arr[j];
            arr[j] = arr[low];
            arr[low] = temp;

        return j;
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

        quickSort(array, 0, arraySize-1);
        printArray(array);

    }
}
