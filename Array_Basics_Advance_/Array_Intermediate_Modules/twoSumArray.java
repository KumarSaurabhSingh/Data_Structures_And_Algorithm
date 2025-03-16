//Problem Statement: Given an array of integers arr[] and an integer target.
//1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
//2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class twoSumArray {

    //Bruete Force Approach
    //Time Complexity - O(N * N)
    //Space Complexity - O(1)
    static int[] brueteForce(int[] array, int num){

        int[] ans = new int[2];
        ans[0] =ans[1] = -1;

        for(int i=0; i<array.length; i++){

            for(int j=i+1; j<array.length; j++){

                if(array[i] + array[j] == num){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
    }

    //Better Approach - Using HashMap
    //Time Complexity - O(N * Log N)
    // Space Complexity - O(N)
    static int[] betterApproach(int[] array, int num){

        HashMap<Integer, Integer> temp = new HashMap<>();

        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        for(int i=0; i<array.length; i++){
            int rem = num - array[i];

            if(temp.containsKey(rem)){
                ans[0] = temp.get(rem);
                ans[1] = i;
            }

            else{
                temp.put(array[i], i);
            }
        }

        return ans;
    }

    //Optimal Approach if result is Yes / No but not for the case where result is having the indexes(better is optimal)
    //Time Complexity - O(N) + O(N * Log N)
    //Space Complexity - O(N) - if we consider the distortion of the Array
    static String optimalApproach(int[] array, int num){

        Arrays.sort(array); // O(N * LogN)

        int left = 0;
        int right = array.length-1;

        while (left < right){
            int sum = array[left] + array[right];

            if(sum == num){
                return "Yes";
            }

            if(sum < num){
                left ++;
            }

            else{
                right--;
            }
        }

        return "NO";
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

        //Input for searched sum value
        int num = input.nextInt();

        
        //int [] result = brueteForce(array, num);

        //int [] result = betterApproach(array, num);
        //System.out.println(result[0] + " " + result[1]);

        String result = optimalApproach(array, num);
        System.out.println(result);
    }
}
