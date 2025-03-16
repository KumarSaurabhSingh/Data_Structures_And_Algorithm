//Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class longestSubArray {

    //The Bruete Force Approach
    //Time Compplexity - O(N*N)
    //Space Complexity - O(1)
    static void brueteForceApproach(int[] array, int num){

        int maxSum =0;
        for(int i=0; i<array.length; i++){

            int sum =0;
            int count =0;
            for(int j=i; j<array.length; j++){
                    sum = sum + array[j];

                //System.out.println("count  " +count);
                if(sum == num)
                maxSum = Math.max(maxSum, j-i+1);
                
            }
        }

        System.out.println("Max Length will be  " + maxSum);
    }
    

    //Bruete Force Approach - Part 2
    //Time Complexity - O(N*N)
    //Space Complexity - O(1)
    public static void getLongestSubarray(int []a, long k) {
        int n = a.length; // size of the array.

        int len = 0;
        for (int i = 0; i < n; i++) { // starting index
            long s = 0; // Sum variable
            for (int j = i; j < n; j++) { // ending index
                // add the current element to
                // the subarray a[i...j-1]:
                s += a[j];

                if (s == k)
                    len = Math.max(len, j - i + 1);
            }
        }
        System.out.println(len);;
    }


    //The better solution approach (Using Hashing)
    //This better approach is best for negative test cases
    static void betterSolution(int[] array, long num){

        Map<Long, Integer> sumMap = new HashMap<>();

        long sum =0;
        int maxLen =0;

        for(int i=0; i<array.length; i++){

            sum = sum + array[i];

            if(sum == num){
                maxLen = Math.max(maxLen, i+1); //here i+1 behaves a s count ++
            }

            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - num;

            //Calculate the length and update maxLen:
            if(sumMap.containsKey(rem)){
                int length = i - sumMap.get(rem);
                maxLen = Math.max(maxLen, length);

            }

            if(!sumMap.containsKey(sum)){
                sumMap.put(sum, i);
            }
        }

        System.out.println("MaxLength  " +maxLen);
    }


    //Optimal Approach
    //This optimal approach will not be fruitful for negative test cases
    //Space Complexity: O(1) as we are not using any extra space.
    //Time Complexity: O(2*N), where N = size of the given array.
    static void optimalApproach(int[] array, int num){

        int left =0;
        int right =0;
        long sum = array[0]; //inserting the very forst element of the array.
        int maxLength = 0;

        while(right<array.length){

            // if sum > num, reduce the subarray from left
            // until sum becomes less or equal to num:
            while(left <= right && sum > num){
                sum = sum - array[left];
                left++;
            }
            // if sum = k, update the maxLen i.e. answer:
            if(sum ==num){
                maxLength = Math.max(maxLength, right - left +1);
                System.out.println("Maxxy" + maxLength);
            }

            // Move forward thw right pointer:
            right++;
            if(right<array.length){
                sum = sum + array[right];
            }

            //System.out.println(maxLength);
        }

        System.out.println("MaxLength " +maxLength);
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
        //Input for num
        int num = input.nextInt();

        //Bruete Force Approach Results
        brueteForceApproach(array, num);
        //getLongestSubarray(array, num);


        //Better Solution Results
        //betterSolution(array, num);


        //Optimal Approach Result
        //optimalApproach(array, num);
    }
}
