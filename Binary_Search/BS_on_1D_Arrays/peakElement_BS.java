import java.util.ArrayList;
import java.util.Scanner;

/*
Problem Statement: Given an array of length N. Peak element is defined as the element greater than both of its neighbors.
Formally, if 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'.
Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.
 */

public class peakElement_BS {

    //Time Complexity: O(logN), N = size of the given array.
    //Reason: We are basically using binary search to find the minimum.
    //Space Complexity: O(1)
    static int peakElement_BS(int[] array){

        int n = array.length;
        if(n ==1) return 0;

        if(array[0] > array[1]) return 0;
        if(array[n-1] > array[n-2]) return n-1;

        int low = 1;
        int high = n-2;

        while(low <= high){

            int mid = (low + high)/2;

            if(array[mid] > array[mid-1] && array[mid] > array[mid+1]){
                return mid;
            }

            else if((array[mid] > array[mid - 1])){
                low = mid+1;
            }

            else{
                high = mid -1;
            }
        }
        return -1;
    }


    //The BrueteForce Approach
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public static int findPeakElement(int[] arr) {
        int n = arr.length; // Size of array.

        for (int i = 0; i < n; i++) {
            // Checking for the peak:
            if ((i == 0 || arr[i - 1] < arr[i])
                    && (i == n - 1 || arr[i] > arr[i + 1])) {
                return i;
            }
        }
        // Dummy return statement
        return -1;
    }
    

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        int res = peakElement_BS(array);
        System.out.println("The Peak Element is at : "+res);
        System.out.println("The Value is : "+ array[res]);

        //The Bruete Force Approach
        int ans = findPeakElement(array);
        System.out.println("The Bruete Approach res : " + ans);
    }
}
