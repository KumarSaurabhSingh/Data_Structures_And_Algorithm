import java.util.ArrayList;
import java.util.Scanner;

//Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)

public class dutchNationalAlgorithm {

    //Bruete Force Approach using Merge Sort
    //Time Complexity - O( N * Log N)
    //Space Complexity - O(N)
    static void brueteForce(int[] array, int low, int mid, int high){

        ArrayList<Integer> temp = new ArrayList<>();

        int left =low;
        int right = mid+1;

        while(left <= mid && right <=high){

            if(array[left] <= array[right]){
                temp.add(array[left]);
                left++;
            }

            else{
                temp.add(array[right]);
                right++;
            }
        }

        while(left <= mid){
                temp.add(array[left]);
                left++;
        }

        while(right <= high){
            temp.add(array[right]);
            right++;
        }

        for(int i=low; i<=high; i++){
            array[i] = temp.get(i-low);
        }
    }


    static void merge(int[] array, int low, int high){

        if(low >= high){
            return;
        }
        int mid = (low + high) /2;

        merge(array, low, mid);

        merge(array, mid+1, high);

        brueteForce(array, low, mid, high);
    }

    //Printing the array
    static void printArray(int[] array){

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    


    //Better Approach
    //Time Complexity - O(N) + O(N) = O(2N)
    //Space Complexity - O(1)
    static void betterApproach(int[] array){

        int count0 = 0;
        int count1 =0;
        int count2 =0;

        for(int i=0; i<array.length; i++){

            if(array[i] ==0) count0++;

            if(array[i] ==1) count1++;

            if(array[i] ==2) count2++;
        }

        for(int i=0; i<count0; i++){
            array[i] =0;
        }

        for(int i=count0; i< count0+count1; i++){
            array[i] =1;
        }

        for(int i=count0+count1; i< array.length; i++){
            array[i] =2;
        }
    }

    //Most Optimal Approach - Dutch National Algorithm
    static void optimalApproach(int[] array){

        int low =0;
        int mid =0;
        int high = array.length-1;

        while (mid <= high){

            if(array[mid] ==0){
                int temp = array[low];
                array[low] = array[mid];
                array[mid] = temp;
                low++;
                mid++;
            }

            else if(array[mid] ==1){
                mid++;
            }

            else if(array[mid] ==2){
                // Swap array[mid] and array[high]
                int temp = array[high];
                array[high] = array[mid];
                array[mid] = temp;
                high--;
            }
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

        printArray(array);
        System.out.println();

        //Bruete Force Approach
        //merge(array, 0, arraySize-1);
        //printArray(array);


        //Better Solution
        //betterApproach(array);
        //printArray(array);


        //Optimal Approach
        optimalApproach(array);
        printArray(array);
    }
}
