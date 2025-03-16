import java.util.Scanner;

/*
Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values).
Now the array is rotated between 1 to N times which is unknown. Find how many times the array has been rotated.

 */

public class rotatedArrayIndex {

    //Time Complexity: O(logN), N = size of the given array.
    //Space Complexity: O(1)
    static int rotatedArrayIndex(int[] array){
        int n = array.length;
        int low =0;
        int high =n-1;
        int ans = Integer.MAX_VALUE;
        int index =-1;

        while(low<= high){

            int mid = (low + high)/2;

            if(array[low] <= array[mid]){

                if(array[low] < ans){
                    index = low;
                    ans = array[low];
                }
                low = mid +1;

            }
            else{
                high = mid -1;
                if(array[mid] < ans){
                    index = mid;
                    ans = array[mid];
                }
            }
        }

        System.out.println("Minimum Value pf The Array : "+ans);

        return index;
    }
    
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        int res = rotatedArrayIndex(array);
        System.out.println("Rotation Value is : "+res);
    }
}
