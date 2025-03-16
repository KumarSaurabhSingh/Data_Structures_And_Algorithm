import java.util.Scanner;

public class kokoEatingBanana {

    static double function(int[] array, int num){
        int n = array.length;
        double ans =0;
        System.out.println("Num value " + num);
        for(int i=0; i<n; i++){
            ans = ans + Math.ceil((double)array[i]/(double)num);
        }

        return ans;
    }

    //Finding the highest number
    static int high(int[] array){
        int max = Integer.MIN_VALUE;

        for(int i=0; i<array.length; i++){
            max = Math.max(max, array[i]);
        }

        return max;
    }


    //Without Using the third value to store the answer.
    static int optimalApproach(int[] array, int num){

        int n = array.length;
        int low =1;
        int high = high(array);
        int ans = -1;

        while(low <= high){

            int mid = (low + high)/2;
            double val = function(array, mid);
            System.out.println("Val value  " +val);
            if(val <= num){
                high = mid-1;
                ans = Math.max(ans, mid);
            }

            else{
                low = mid+1;
            }
        }

        return low;
    }

    //Using Third Value to store the answer
    static int optimalApproach1(int[] array, int num){

        int n = array.length;
        int low =1;
        int high = high(array);
        int ans = -1;

        while(low <= high){

            int mid = (low + high)/2;
            double val = function(array, mid);
            System.out.println("Val value  " +val);
            if(val <= num){
                high = mid-1;
                //low = mid+1;
                ans = mid;
                System.out.println("ANS Value : "+ ans);
            }

            else{
                low = mid+1;
                //high = mid-1;
            }
        }

        return ans;
    }
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i =0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //Input hours
        int hrs = input.nextInt();

        //The Optimal Approach
        int res = optimalApproach1(array, hrs);
        System.out.println("The Minimum value will be : "+ res);
    }
}
