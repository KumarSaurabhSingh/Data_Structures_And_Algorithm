import java.util.Scanner;


public class largestElementArray {

    //Time Complexity will be O(N)
    //Space Complexity will be O(1)
    static int largestElementArray(int[] array){

        int max =0;
        for(int i=0; i<array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        return max;
    }
    

    //Brute Force Method
    //Using Quick sort Method 
    static void bruteForceMethod(int[] array, int low, int high){

        if(low<high){

            int pivot = pivotIndex(array, low, high);

            //System.out.println(pivot);

            bruteForceMethod(array, low, pivot-1);

            bruteForceMethod(array, pivot+1, high);
        }
    }

    //pivot Index for quicksort method
    static int pivotIndex(int[] array, int low, int high){

        int i= low;
        int j= high;
        int pivot = array[i];

        while(i<j){

            while(array[i] <= pivot && i<high-1){
                i++;
            }

            while(array[j] > pivot && j>low+1){
                j--;
            }

            if(i<j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;

        return j;

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

        // int result = largestElementArray(array);
        // System.out.println(result);

        bruteForceMethod(array,0, arraySize-1);
        System.out.println(array[arraySize-1]);

    }
}
