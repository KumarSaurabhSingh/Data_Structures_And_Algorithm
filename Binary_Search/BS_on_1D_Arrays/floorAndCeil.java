import java.util.Scanner;

public class floorAndCeil {
    
    //Time complexity is O(logN), where N = size of the given array. At base 2
    static int floorAndCeil(int[] array, int target){

        int n = array.length;
        int low =0;
        int high = n-1;

        int ans =-1;

        while(low<= high){

            int mid = (low + high)/2;

            if(array[mid] <= target){
                ans = array[mid];
                low = mid+1;
            }

            else{
                high = mid-1;
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

        //The Lower Bound method
        int result = floorAndCeil(array, target);
        System.out.println("The Floor Position : "+result);
    }
}
