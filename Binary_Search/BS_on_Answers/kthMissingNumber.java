import java.util.Scanner;

/*Problem Statement: You are given a strictly increasing array ‘vec’ and a positive integer 'k'.
Find the 'kth' positive integer missing from 'vec'. */

public class kthMissingNumber {

    //The Bruete Force Approach
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    static int brueteForce(int[] array, int limit){

        int ans = -1;
        int n = array.length;
        for(int i=0; i<n; i++){
            if(array[i] <=limit){
                limit++;
            }

            else{
                ans = limit;
                break;
            }
        }

        return ans;
    }

    //The Optimal Approach
    static int optimalApproach(int[] array, int limit){

        int n = array.length;
        int low =0, high =n-1;

        while(low <= high){

            int mid = (low + high)/2;
            int missing = array[mid] - (mid+1);

            if(missing < limit){
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }

        return (limit +high +1);
    }

    

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //Input for Number of Days
        int limit = input.nextInt();

        //The Bruete Force Approach
        int res =brueteForce(array, limit);
        System.out.println("The Kth missing number : "+ res);

        //The Optimal Solution
        int responce = optimalApproach(array, limit);
        System.out.println("(Optimal) Kth missing : "+ responce);
    }
}
