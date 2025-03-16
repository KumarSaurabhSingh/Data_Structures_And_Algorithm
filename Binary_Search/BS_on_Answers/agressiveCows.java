import java.util.Arrays;
import java.util.Scanner;
//Hard Binary Search
/*Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls.
You are also given an integer 'k' which denotes the number of aggressive cows.
You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
Find the maximum possible minimum distance. */

public class agressiveCows {

    static boolean minDistance(int[] array, int cows, int dst){
        int n = array.length;
        int last = array[0];
        int currCows =1;

        for(int i =1; i<n; i++){
            if(array[i] - last >= dst){
                currCows++;
                last = array[i];
            }
        }

        if(currCows >= cows){
            return true;
        }

        else return false;
    }


    //The Bruete Force Approach
    //Time Complexity - Time Complexity: O(NlogN) + O(N *(max(stalls[])-min(stalls[]))), where N = size of the array, max(stalls[]) = maximum element in stalls[] array, min(stalls[]) = minimum element in stalls[] array.
    //Space Complexity - O(1)
    static int brueteForce(int[] array, int cows){
        int n = array.length;

        //Sorting the given Array
        Arrays.sort(array);
        int maxi = array[n-1] - array[0];
        int ans =0;

        for(int i =0; i<=maxi; i++){

            boolean responce = minDistance(array, cows, i);
            if(responce == true){
                ans = i;
            }

        }

        return ans;
    }


    //The Optimal Approach
    //Time Complexity: O(NlogN) + O(N * log(max(stalls[])-min(stalls[])))
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.
    static int optimalApproach(int[] array, int cows){

        int n = array.length;
        int ans =0;

        Arrays.sort(array);

        int low =1;
        int high =array[n-1] - array[0];

        while(low <= high){

            int mid = (low + high)/2;

            boolean res = minDistance(array, cows, mid);
            if(res == true){
                ans = mid;
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

        //Input for Number of Cows
        int cows = input.nextInt();

        //The Bruete Force Approach
        int res = brueteForce(array, cows);
        System.out.println("(Bruete) The minimum distance (Max): " + res);

        //The Optimal Approach
        int responce = optimalApproach(array, cows);
        System.out.println("(Optimal) The mini distance (Max) : "+ responce);
    }
}
