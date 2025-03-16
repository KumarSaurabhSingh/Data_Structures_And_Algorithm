import java.util.Scanner;


//Time complexity of the selection sort will be O(n square)
//The above time complexity is for Best, Average and Worst case

public class selectionSort {
    
    static int[] selectionSort(int arr[]){

        for(int i=0; i<=arr.length - 2; i++){

            int mini = i;

            for(int j=i; j<=arr.length - 1; j++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }


            int temp =0;
            temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
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

        int[] result = selectionSort(array);
        printArray(result);

    }
}
