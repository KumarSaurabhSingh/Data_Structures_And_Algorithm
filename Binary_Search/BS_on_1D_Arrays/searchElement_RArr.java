import java.util.Scanner;

/*Problem Statement: Given an integer array arr of size N, sorted in ascending order (may contain duplicate values) and a target value k. 
Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False.  */

public class searchElement_RArr {

    //Time Complexity: O(logN) for the best and average case. O(N/2) for the worst case. Here, N = size of the given array.
    //Space Complexity: O(1)
    static boolean searchElement_RArr(int[] array, int target){

        int n = array.length;

        int low =0;
        int high = n-1;

        while(low <= high){

            int mid = (low + high)/2;

            if(array[mid] == target){
                return true;
            }

            if(array[low] == array[mid] && array[mid] == array[high]){
                low = low +1;
                high = high -1;
                continue;
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

        return false;
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

        boolean res = searchElement_RArr(array, target);
        System.out.println("Search Position is : "+res);
    }
}
