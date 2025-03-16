import java.util.Scanner;

public class paintersPartition {

    //Finding the Maximum of the Array
    static int maximum(int[] array){
        int n = array.length;
        int mini = Integer.MIN_VALUE;
        for(int i =0; i<n; i++){

            mini = Math.max(mini, array[i]);
        }

        return mini;
    }

    //Finding Sum of The Array
    static int sum(int[] array){
        int n = array.length;
        int sum = 0;
        for(int i =0; i<n; i++){

            sum = sum+ array[i];
        }

        return sum;
    }

    static int painters(int[] array, int painter){
        int n = array.length;

        int low = maximum(array);
        int high = sum(array);
        int ans = -1;

         // paint allocation impossible
        if (painter > n)
        return -1;

        while(low <= high){

            int mid = (low + high)/2;
            int poss = painterCount(array, painter, mid);

            if(poss >= painter){
                high = mid-1;
                ans = mid;
            }

            else{
                low = mid+1;
            }
        }

        return ans;
    }

    static int painterCount(int[] array, int painter, int limit){
        int n = array.length;
        int curr = 0;
        int person =1;

        for(int i=0; i<n ; i++){

            if(curr + array[i] > limit){
                curr = array[i];
                person++;
            }
            else{
                curr = curr + array[i];
            }
        }

        if(person == painter){
            return person;
        }

        return -1;
    }
    

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //Input for Number of painters
        int painters = input.nextInt();

        //The Bruete Force Approach
        int res = painters(array, painters);
        System.out.println("Maxi Paint Limit : " + res);

        // int responce = optimalApproach(array, student);
        // System.out.println("(Optimal) Maxi page limit : "+ responce);
    }
}
