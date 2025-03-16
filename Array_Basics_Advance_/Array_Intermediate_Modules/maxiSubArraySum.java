import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class maxiSubArraySum {


    //Bruete Force Approach
    //Time Complexity - O(N * N * N) = O(N^3)
    //Space Complexity - O(1)
    static void brueteForce(int[] array){

        int max =0;

        for(int i=0; i<array.length; i++){

            for(int j=i; j<array.length; j++){

                int sum =0;
                for(int k=i; k <=j; k++){

                    sum = sum +array[k];

                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
    

    //Better Approach
    //Tie Complexity - O(N * N) = O(N^2)
    //Space Complexity - O(1)

    static void betterApproach(int[] array){

        int max = Integer.MIN_VALUE;

        for(int i=0; i<array.length; i++){

            int sum =0;

            for(int j=i; j<array.length; j++){

                sum = sum +array[j];

                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }

    //Optimal Approach - Kadane's Algorithm
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    static void kadaneAlgorithm(int[] array){

        int max = Integer.MIN_VALUE;
        int sum =0;
        int start =0;
        int firstStart =-1;
        int endStart = -1;

        for(int i=0; i<array.length; i++){

            if(sum ==0){
                start = i;
            }
                sum = sum + array[i];

            if(sum <0){
                sum =0;

            }

            if(sum > max){
                max = Math.max(max, sum);
                firstStart = start;
                endStart = i;
            }
        }

        System.out.println("Maximam Count will be : "+max);
        System.out.println("Indexes will be :  "+firstStart + " " + endStart);
    }

    static int kadane(int[] array){
    //Kadane to handle negative input
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;

    for (int num : array) {
        currentSum += num;
        maxSum = Math.max(maxSum, currentSum);

        // If currentSum goes below zero, reset it
        if (currentSum < 0) {
            currentSum = 0;
        }
    }

    return maxSum;
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

        //Bruete Force Approach
        //brueteForce(array);

        //Better Approach
        //betterApproach(array);

        //Optimal Approach
        //kadaneAlgorithm(array);

        //Kadane
        // int res =kadane(array);
        // System.out.println(res);

        maxSum(array);
    }


    static void maxSum(int[] array){
        int n = array.length;

        int low =0;
        int high = n-1;

        Arrays.sort(array);

        int max = array[n-1] +array[n-2];

        System.out.println(max);
    }
}
