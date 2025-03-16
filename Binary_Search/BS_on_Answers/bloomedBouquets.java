import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bloomedBouquets {

    static int minimum(int[] array){
        int n = array.length;
        int mini = Integer.MAX_VALUE;
        for(int i =0; i<n; i++){

            mini = Math.min(mini, array[i]);
        }

        return mini;
    }

    static int maximum(int[] array){
        int n = array.length;
        int mini = Integer.MIN_VALUE;
        for(int i =0; i<n; i++){

            mini = Math.max(mini, array[i]);
        }

        return mini;
    }


    static int brueteForce(int[] array, int amt, int qnt){

        int n = array.length;
        List<Integer> ans = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>(0);

        if(n < amt*qnt){
            return -1;
        }
        int mini = minimum(array);
        int maxi = maximum(array);

        for(int i=mini; i<=maxi; i++){
            int count = 0;
            int temp_amt = amt;

            for(int j=0; j<n; j++){

                if(count==qnt){
                    count =0;
                    temp_amt--;
                }

                if(array[j] <= i){
                    count ++;
                }

                else{
                    count =0;
                }
            }
            if(count==qnt){
                temp_amt--;
            }

            if(temp_amt ==0){
                return i;
            }
        }
        return -1;
        // return ans;
    }

    //possible or not
    static boolean possible(int[] array,int k, int amt, int qnt){
        int n = array.length;
        int count = 0;
        int ans =0;
        for(int i=0; i<n; i++){

            if(array[i] <= k){
                count ++;
            }

            else{
                ans = count/qnt;
                count =0;
            }
        }
        ans = ans + (count/qnt);

        if(ans >= amt){
            return true;
        }

        return false;
    }


    //The Optimal Solution Binary Search
    //Time Complexity: O(log(max(arr[])-min(arr[])+1) * N),
    //where {max(arr[]) -> maximum element of the array, min(arr[]) -> minimum element of the array, N = size of the array}.
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.
    static int optimalApproach(int[] array, int amt, int qnt){

        int low = minimum(array);
        int high = maximum(array);
        int ans = -1;

        while(low <= high){

            int mid = (low +high)/2;
            boolean res = possible(array, mid, amt, qnt);
            if(res == true){
                ans = mid;
                high = mid-1;
                //low = mid+1; // If I want the maximum day
            }

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

        //Input for bouquets quantity
        int amt = input.nextInt();

        //Input for bouquets size
        int qnt = input.nextInt();

        //Bruete Force Approach
        int res = brueteForce(array, amt, qnt);
        System.out.println("Bruete - Mini Day : "+ res);

        //The Optimal Approach
        int responce = optimalApproach(array, amt, qnt);
        System.out.println("Optimal - Mini Day : "+ responce);
    }
}
