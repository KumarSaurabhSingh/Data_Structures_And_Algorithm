import java.util.Scanner;

public class smallestDivisorThresold {

    static boolean possible(int[] array, int num, int limit){
        int n = array.length;

        double sum = 0;

        for(int i =0; i<n; i++){
            sum = sum + Math.ceil((double)array[i]/(double)num);
        }

        if(sum <= limit){
            return true;
        }

        return false;
    }

    //Finding the max element
    static int maximum(int[] array){
        int n = array.length;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            max = Math.max(max, array[i]);
        }

        return max;
    }

    //The Bruete Force Approach
    //Time Complexity - O(Max) * O(N)
    //Space Complexity - O(1)
    static int brueteForce(int[] array, int num){

        int n = array.length;
        int max = maximum(array);

        for(int i=0; i<max; i++){
            boolean poss = possible(array, i, num);
            if(poss == true){
                return i;
            }
        }

        return -1;
    }
    

    //The Optimal Approach
    static int optimalApproach(int[] array, int limit){

        int n = array.length;
        int low =1;
        int high = maximum(array);
        int ans = -1;

        while(low <= high){

            int mid = (low + high)/2;

            boolean responce = possible(array, mid, limit);
            if(responce == true){
                ans = mid;
                high = mid-1;
            }

            else{
                low = mid+1;
            }
        }
        System.out.println("Smallest value will be : "+low);

        return ans;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //Input for limit
        int limit = input.nextInt();

        //The Bruete Force Approach
        int res = brueteForce(array, limit);
        System.out.println("(Bruete Force) Smallest : "+ res);

        //The Optimal Approach
        int responce = optimalApproach(array, limit);
        System.out.println("(Optimal) Smallest : " + responce);
    }
}
