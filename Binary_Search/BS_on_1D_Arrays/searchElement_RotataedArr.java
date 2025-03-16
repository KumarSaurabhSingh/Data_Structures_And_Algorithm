import java.util.Scanner;

/*Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k.
Now the array is rotated at some pivot point unknown to you.
Find the index at which k is present and if k is not present return -1. */

public class searchElement_RotataedArr {
    
    //The Problem statement have only unique elements
    // Time Complexity - O(Log N at base 2)
    //Space Complexity - O(1)
    static int searchElement_RotataedArr(int[] array, int target){

        int n = array.length;
        int low =0;
        int high = n-1;
        
        while(low <= high){

            int mid = (low + high)/2;

            if(array[mid] == target){
                return mid;
            }

            if(array[low] <= array[mid]){

                if(array[low] <= target && array[mid] >= target){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{

                if(array[mid] <= target && array[high] >= target){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //The Target to search
        int target = input.nextInt();

        int res = searchElement_RotataedArr(array, target);
        System.out.println("Search Position is : "+res);
    }
}
