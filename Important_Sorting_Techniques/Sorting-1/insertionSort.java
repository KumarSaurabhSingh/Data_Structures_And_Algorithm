import java.util.Scanner;

//Insertion Sort
//Time complexity -> Worst and Average case -> O(N square)
//Time Complexity -> Best Case -> 0(N)

public class insertionSort {
    
    static int[] insertionSort(int[] arr){

        for(int i=0; i<arr.length; i++){

            int j=i;
            while(j>0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

                j--;
            }
        }

        return arr;

    }

    static void printArray(int array[]){
        for(int i=0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args){
        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        int[] array = new int[arraySize];

        for(int i=0; i<arraySize; i++){

            array[i] = input.nextInt();
        }

        int[] result = insertionSort(array);
        printArray(result);

    }
}
