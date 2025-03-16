import java.util.Scanner;

//The time complexity of the bubble sort will be O(n square) -> Average and worst case
//The best case will be O(N) if the array is pre-ordered

public class bubbleSort {

    static int[] bubbleSort(int[] arr){

        for(int i= arr.length -1; i>=0; i--){

            int didRun =0; //To check if the array is sorted or not

            for(int j=0; j<=i-1; j++){
                if(arr[j] > arr[j+1]){

                    int mini =0;
                    mini = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = mini;

                    didRun =1;
                }
            }

            if(didRun ==0){
                break; //Means the loops gets the freely iterate because all of the data is sorted.
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

        int[] result = bubbleSort(array);
        printArray(result);

    }
}
