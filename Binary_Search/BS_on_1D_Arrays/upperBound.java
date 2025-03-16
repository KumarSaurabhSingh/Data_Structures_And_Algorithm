import java.util.Scanner;

public class upperBound {
    
    //Time complexity is O(logN), where N = size of the given array. At base 2
    static int upperBound(int[] array, int target){

        int n = array.length;
        int low =0;
        int high = n-1;
        int ans =n;
        while(low <= high){

            int mid = (low + high)/2;

            if(array[mid] > target){
                ans = mid;
                high = mid-1;
            }

            else{

                low = mid+1;
            }
        }

        return ans;
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

        //The Lower Bound
        int result = upperBound(array, target);
        System.out.println("The Upper Bound : "+result);
    }
}
