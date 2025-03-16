import java.util.ArrayList;
import java.util.Scanner;

//Time complexity of the merge sort is O(N * Log N at base 2) -> Best, Average and Worst case
//Space Complexity for the worst case will be O(N)

public class mergeSort {

    static void merge(int[] array, int low, int mid, int high){

        ArrayList<Integer> Temp = new ArrayList<>(); // temporary array
        int left = low; // starting index of left half of arr
        int right = mid +1;  // starting index of right half of arr


        //storing elements in the temporary array in a sorted manner//

        while (left<= mid && right <= high ){

            if(array[left] <=array[right]){
                Temp.add(array[left]);
                left++;
            }

            else{
                Temp.add(array[right]);
                right++;
            }
        }

        // if elements on the left half are still left //
        while(left <= mid){
            Temp.add(array[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while(right <=high){
            Temp.add(array[right]);
            right++;
        }

         // transfering all elements from temporary to arr //
        for(int i= low; i<=high; i++){
            array[i] = Temp.get(i-low);
        }

    }

    //Printing the array
    static void printArray(int[] array){

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static void mergeSorting(int[] array, int low, int high){

        if(low >= high){
            return;
        }

        int mid = (low +high)/2;

        //First Half of the array
        mergeSorting(array, low, mid);

        //Second half of the array
        mergeSorting(array, mid+1, high);

        merge(array, low, mid, high);
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

        mergeSorting(array, 0, arraySize-1);
        printArray(array);

    }
}
