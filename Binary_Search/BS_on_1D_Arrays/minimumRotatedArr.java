import java.util.Scanner;

public class minimumRotatedArr {

    static int minimumRotatedArr(int[] array){

        int n = array.length;
        int low =0;
        int high = n-1;
        int ans = Integer.MAX_VALUE;

        while(low<= high){

            int mid = (low + high)/2;

            if(array[mid] >= array[low]){
                ans = Math.min(ans, array[low]);
                low = mid+1;
            }

            else{
                ans = Math.min(ans, array[mid]);
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

        int res = minimumRotatedArr(array);
        System.out.println("Minimum Value is : "+res);
    }
}
