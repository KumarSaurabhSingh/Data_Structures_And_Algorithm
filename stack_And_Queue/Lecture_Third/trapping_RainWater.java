import java.util.Scanner;

public class trapping_RainWater {


    //Time Complexity - O(N^2) -> as for each index we are calculating leftMax and rightMax so it is a nested loop.
    //Space Complexity - O(1)
    static int brueteForce(int[] arr){

        int n = arr.length;
        int waterTrapped = 0;

        for(int i =0; i<n; i++){

            int leftMax =0;
            int j=i;
            while(j >= 0){
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }

            int rightMax =0;
            j=i;
            while(j<n){
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }

            waterTrapped = waterTrapped + Math.min(leftMax, rightMax) - arr[i];
        }

        return waterTrapped;
    }


    //The Better Approach
    static int betterApproach(int[] arr){

        int n = arr.length;
        int waterTrapped = 0;

        //Finding leftMax and storing it separately
        int[] pre = new int[n];
        pre[0] = arr[0];
        for(int i=1; i<n; i++){
            pre[i] = Math.max(arr[i], pre[i-1]);
        }

        //Finding rightMax and storing it separately
        int[] suff = new int[n];
        suff[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            suff[i] = Math.max(arr[i], suff[i+1]);
        }

        //Finding the water trapped
        for(int i =0; i<n; i++){
            waterTrapped += Math.min(pre[i], suff[i])- arr[i];
        }

        return waterTrapped;
    }


    //The Optimal Approach
    //Time Complexity - O(N) -> because we are using 2 pointer approach.
    //Space Complexity - O(1)
    static int OptimalApproach(int[] arr){
        int n = arr.length;
        int leftMax =0;
        int rightMax =0;

        int left =0;
        int right = n-1;
        int total =0;


        while(left < right){

            if(arr[left] <= arr[right]){

                if(leftMax > arr[left]){
                    total = total + leftMax - arr[left];
                }

                else{
                    leftMax = arr[left];
                }
                left++;
            }

            else{
                if(rightMax > arr[right]){
                    total = total + rightMax - arr[right];
                }

                else{
                    rightMax = arr[right];
                }
                right--;
            }
        }

        return total;
    }



    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int[] arr = new int[size];

        for(int i =0; i< size; i++){
            arr[i] = input.nextInt();
        }


        //The Bruete Force Approach
        int brueteAns = brueteForce(arr);
        System.out.println("The Trapped Water : "+ brueteAns);


        //The Better Approach
        int betterAns = betterApproach(arr);
        System.out.println("Trapped Quantity: "+ betterAns);

        //The Optimal Approach
        int optiAns = OptimalApproach(arr);
        System.out.println("Trapped Water : "+ optiAns);
    }
}
