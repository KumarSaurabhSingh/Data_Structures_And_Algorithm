import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class countSubArray {
    

    //The Bruete Force Approach
    //Time Complexity - Near about O(N^3)
    //Space Complexity - O(1)
    static void brueteForce(int[] array, int num){

        int n = array.length;
        int count =0;

        for(int i=0; i<n; i++){

            for(int j=i; j<n; j++){
                int sum = 0;

                for(int k=i; k<=j; k++){
                    sum = sum +array[k];
                }

                if(sum ==num){
                    count++;
                }
            }
        }

        System.out.println(count);
    }


    //The Better Approach
    //Time Complexity - O(N^2)
    //Space Complexity - O(1)
    static void betterApproach(int[] array, int num){

        int n = array.length;
        int count =0;

        for(int i=0; i<n; i++){
            int sum = 0;

            for(int j=i; j<n; j++){
                sum = sum +array[j];
                if(sum ==num){
                    count++;
                }
            }
        }

        System.out.println(count);
    }


    //The Optimal Approach
    static void optimalApproach(int[] array, int num){

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int n = array.length;

        int prefixSum = 0;
        int cnt =0;

        for(int i=0; i<n; i++){

              // add current element to prefix Sum:
            prefixSum = prefixSum + array[i];

            // Calculate x-k:
            int remove = prefixSum-num; //x-k

            // Add the number of subarrays to be removed:
            cnt += map.getOrDefault(remove,0);

            // Update the count of prefix sum
            // in the map.
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);

        }

        System.out.println(cnt);
    }


    public static void main(String[] args){

        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //Taking input in the array
        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        int num = input.nextInt();

        //The Bruete Force Approach
        brueteForce(array, num);

        //The better Approach
        betterApproach(array, num);

        //The optimal Approach
        optimalApproach(array, num);
    }
}
