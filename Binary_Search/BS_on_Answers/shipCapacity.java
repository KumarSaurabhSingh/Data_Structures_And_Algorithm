import java.util.Scanner;

/*Problem Statement: You are the owner of a Shipment company. You use conveyor belts to ship packages from one port to another. The packages must be shipped within 'd' days.
The weights of the packages are given in an array 'of weights'. The packages are loaded on the conveyor belts every day in the same order as they appear in the array. The loaded weights must not exceed the maximum weight capacity of the ship.
Find out the least-weight capacity so that you can ship all the packages within 'd' days. */

public class shipCapacity {

    //Finding the Days
    static int findDays(int[] array, int cap){
        int n = array.length;
        int load =0;
        int days =1;//First day.
        for(int i=0; i<n; i++){
            if(load + array[i] > cap){ //if the load and the curr weight is exceeding the limit
                load = array[i]; //Then load the weight on next day
                days ++; //move to next day
            }
            else{ //If load is under limit then load the weight on the same day.
                load = load+array[i];
            }
        }
        return days;
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
    //Finding sum of the array
    static int sum(int[] array){
        int n = array.length;
        int sum =0;
        for(int i=0; i<n; i++){
            sum = sum+array[i];
        }

        return sum;
    }
    
    //The Bruete Force Approach
    //Time Complexity: O(N * (sum(weights[]) - max(weights[]) + 1)), where sum(weights[]) = summation of all the weights, max(weights[]) = maximum of all the weights, N = size of the weights array.
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.
    static int brueteForce(int[] array, int limit){

        int n = array.length;
        int low = maximum(array);
        int high = sum(array);
        int ans =0;

        for(int i=low; i<=high; i++){

            int days = findDays(array, i);
            if(days == limit){
                ans = i;
            }
        }

        return ans;
    }



    //The Optimal Approach
    //Time Complexity: O(N * log(sum(weights[]) - max(weights[]) + 1)), where sum(weights[]) = summation of all the weights, max(weights[]) = maximum of all the weights, N = size of the weights array.
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.
    static int optimalApproach(int[] array, int limit){

        int low = maximum(array);
        int high = sum(array);
        int ans = -1;

        while( low <= high){

            int mid = (low + high)/2;
            int days = findDays(array, mid);

            if(days <= limit){
                ans = mid;
                high = mid -1;

            }

            // else if(days < limit){
            //     high = mid-1;
            // }

            else{
                low = mid+1;
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

        //Input for Number of Days
        int limit = input.nextInt();

        //The Bruete Force Approach
        int res = brueteForce(array, limit);
        System.out.println("(Bruee) The Mini Load : " + res);

        //The Optimal Approach
        int res1 = optimalApproach(array, limit);
        System.out.println("(Optimal) The Mini Load : " + res1);
    }
}
