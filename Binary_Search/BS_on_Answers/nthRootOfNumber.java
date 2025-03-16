import java.util.Scanner;

public class nthRootOfNumber {

    //Function to perform Root
    static long fun(int num, int k, int value){
        long ans =1;

        while(k >0){

            if(k%2 ==1){
                ans = ans * num;
                k = k-1;
            }

            else{
                num = num * num;
                k = k/2;
            }

            // if (ans > value){
            //     return 2;
            // }
        }

        return ans;
    }


    //Function using loops
    static int function(int num, int k, int val){
        long ans =1;
        for(int i=0; i<num; i++){

            ans = ans*i;
            if(ans > num) return 2;

        }

        if(ans == num) return 1;

        return 0;
    }



    //The Bruete Force Approach
    //Time Complexity: O(M), M = the given number.
    //Space Complexity: O(1) as we are not using any extra space.
    static int brueteForce(int num, int k){
        int ans =1;

        for(int i=1; i<num; i++){
            long val = fun(i, k, num);
            if(val == num){
                ans = i;
                return ans;
            }

            else if(val > num){
                break;
            }
        }
        return -1;
    }


    //The Optimal Approach
    //Time Complexity: O(logN), N = size of the given array.
    //Space Complexity: O(1)
    static int optimalApproach(int num, int k){
        int ans =1;
        int low =0;
        int high = num;

        while(low <= high){

            int mid = (low + high)/2;

            long val = fun(mid, k, num);
            if(val == num){
                ans = mid;
                return ans;
            }

            else if(val < num){
                low = mid +1;
            }

            else{
                high = mid-1;
            }
        }
        return -1;
    }

    //Alternative
    /*
     * static int optimalApproach(int num, int k){
        int ans =1;
        int low =0;
        int high = num;

        while(low <= high){

            int mid = (low + high)/2;

            long val = fun(mid, k, num);
            if(val == 1){
                ans = mid;
                return ans;
            }

            else if(val == 0){
                low = mid +1;
            }

            else{
                high = mid-1;
            }
        }
        return -1;
    }
     */
    

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        //Number of time Root performed
        int sqrt = input.nextInt();

        //The Bruete Force Approach
        int res = brueteForce(num, sqrt);
        System.out.println("The Bruete Force Approch : "+res);

        int responce = optimalApproach(num, sqrt);
        System.out.println("The Optimal Approach will be : " + responce);

    }
}
