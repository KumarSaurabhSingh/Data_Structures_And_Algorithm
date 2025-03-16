import java.util.Scanner;

public class binarySearch {
    
    //The Binary Searchh implementation based on Iterator method
    //Time complexity is O(logN), where N = size of the given array.
    static int iteratorBinary(int[] array, int target){

        int n = array.length;
        int low =0;
        int high = n-1;

        while(low<=high){

            int mid = (low + high)/2;

            if(array[mid] == target) return mid;

            else if(array[mid] < target){
                low = mid+1;
            }

            else{
                high = mid -1;
            }
        }

        return -1;
    }

    //The Binary Search using Recursions
    // Time complexity is O(logN), where N = size of the given array. At base 2
    static int recursiveBinarySearch(int[] array, int low, int high, int target){

        if(low > target){
            return -1;
        }

        int mid = (low + high)/2;

        if(array[mid] == target){
            return mid;
        }

        else if(target > array[mid]){
            return recursiveBinarySearch(array, mid+1, high, target);
        }
        
        return recursiveBinarySearch(array, low, mid-1, target);
    }


    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //Input for the Target Value to search
        int target = input.nextInt();

        //Binary Search Using Interator
        int result = iteratorBinary(array, target);
        //System.out.println("The Target Index : "+result);

        //Binary Search Using Recursive Functions
        int res = recursiveBinarySearch(array, 0, arraySize-1, target);
        System.out.println("The Target Index (Recursive) : " + res);
    }
}
