import java.util.HashMap;
import java.util.Scanner;

//Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.

public class missingElementArray {

    //The Bruete force approach
    //Time complexity - O(NxN) worst scenario
    //Space Complexity - O(1)
    static void missingElementArray(int[] array, int num){

        for(int i=1; i<=array.length; i++){
            //This loops is for the number to be compared with the array elements

            int flag=0;
            for(int j=0; j<num; j++){
                //This loops is for iterating each time inside the loop by checking the elements of the array.

                if(array[j] == i){
                    flag =1;
                    break;
                }
            }

            if(flag ==0){
                System.out.println(i);
            }
        }
    }


    //The Better approach
    //Time Complexity - O(N) + O(N) = O(2N)
    //Space Complexity - O(N)
    static void betterApproach(int[] array, int num){

        int[] flag = new int[num +1];

        for(int i=0; i<array.length; i++){
            flag[array[i]]++;
        }

        for(int i=1; i<=flag.length; i++){
            if(flag[i] ==0){
                System.out.println(i);
            }
        }
    }

    //The Optimal Approach part -1
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    static void optimalApproachFirst(int[] array, int num){

        int sum = (num*(num +1))/2;

        int combine=0;
        for(int i=0; i<array.length; i++){

            combine = combine +array[i];
        }

        int result = sum - combine;
        System.out.println(result);
    }


    //The Optimal Approach Part - 2
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    //Better than first one beacuse if there is a case of number 10^5 size then formula will make the value exceed 10^10 which can't be stored in INT datatype
    //Then we need to change it to long which will occupy more space.
    static void optimalSecondApproach(int[] array, int num){
        int xor1 =0;
        int xor2 =0;

        // XOR elements of the array
        for (int i = 0; i < array.length; i++) {
            xor2 = xor2 ^ array[i];
        }

        // XOR all numbers from 1 to num
        for (int i = 1; i <= num; i++) {
            xor1 = xor1 ^ i;
        }

        // Missing number is xor1 ^ xor2
        System.out.println("Result will be: " + (xor1 ^ xor2));
    }

    
    public static void main(String[] args){

        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //Taking input in the array
        int[] array = new int[arraySize-1];
        for(int i=0; i<arraySize-1; i++){
            array[i] = input.nextInt();
        }

        //missingElementArray(array, arraySize);
        //betterApproach(array, arraySize);
        //optimalApproachFirst(array, arraySize);
        optimalSecondApproach(array, arraySize);
    }
}
