import java.util.ArrayList;
import java.util.Scanner;

public class countInversion {

    //The Bruete Force Approach
    //Time Complexity - O(N ^2)
    //Space Complexity - O(1)
    static void brueteForce(int[] array){

        int n = array.length;
        int count =0;

        for(int i=0; i<n; i++){

            for(int j = i+1; j<n; j++){

                if(array[i] > array[j]){
                    count ++;
                }
            }
        }

        System.out.println("The Maximum Inversion Count : " + count);
    }

    //The Optominal Approach --> Using Merge Sort
    static void optimalApproach(int[] array){
        int n =array.length;
        int result = mergeSort(array, 0, n-1);

        System.out.println(result);
    }

    //Merge Sort
    static int mergeSort(int[] array, int low, int high){

        int cnt =0;

        if(low >= high){
            return cnt;
        }

        int mid = (low + high)/2;

        //First Half of the array
        cnt += mergeSort(array, low, mid);

        //Second Half of the array
        cnt += mergeSort(array, mid+1, high);

        cnt += sorting(array, low, mid, high);
        return cnt;
    }
    
    //Sorting Using Merge Sort Technique
    static int sorting(int[] array, int low, int mid, int high){

        int count =0;

        ArrayList<Integer> temp = new ArrayList<>();

        int n = array.length;
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high ){

            if(array[left] <= array[right]){
                temp.add(array[left]);
                left++;
            }

            else{
                temp.add(array[right]);
                //if(array[left] > 2* array[right]){
                    count += (mid - left + 1); //Modification 2
                //}
                right++;
            }
        }
        // if elements on the left half are still left //
        while(left <= mid){
        while(left <= mid){
            temp.add(array[left]);
                left++;
        }
        //  if elements on the right half are still left //
        while(right <= high){
            temp.add(array[right]);
            right++;
        }

         // transfering all elements from temporary to arr //
        for(int i= low; i<=high; i++){
            array[i] = temp.get(i-low);
        }
    }

    return count;
}

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];

        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //The Bruete Force Approach
        //brueteForce(array);

        //The Optimal Approach
        optimalApproach(array);
        printArray(array);
    }




    //Printing the array
    static void printArray(int[] array){

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
