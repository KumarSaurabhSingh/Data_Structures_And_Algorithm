import java.util.Scanner;

public class firstAndLastOccurance {

    //The Bruete Force Approach
    //Time COmplexity - O(N)
    //Space Complexity - O(1)
    static int[] brueteForce(int[] array, int target){

        int[] ans = new int[2];
        int first = -1;
        int last = -1;
        int n = array.length;

        for(int i=0; i<n; i++){

            if(array[i] == target){
                
                if(first ==-1){
                    first = i;
                }

                last = i;
            }
        }
        ans[0] =first;
        ans[1] = last;

        return ans;
    }
    
    //The Optimal Approach - We will Use Lower Bound & Upper Bound Method
    static void optimalApproach(int[] array, int target){

        int first = lowerBound(array, target);
        if(first == array.length && array[first] != target){
            System.out.println("No Element Found : "+"-1");
        }
        int last = upperBound(array, target) - 1;
        System.out.println("(UB & LB) Indexes will be : "+ first +" "+ last);

    }

    //Lower Bound
    static int lowerBound(int[] array, int target){

        int n = array.length;
        int low =0;
        int high = n-1;
        int ans = n;

        while(low <= high){

            int mid = (low + high)/2;

            // if(array[mid] == target){
            //     return mid;
            // }

            if( array[mid] >= target){
                ans = mid;
                high = mid-1;
            }

            else{
                low = mid+1;
            }
        }

        return ans;
    }

    //Upper Bound
    static int upperBound(int[] array, int target){

        int n = array.length;
        int low =0;
        int high = n-1;
        int ans =n;

        while(low <= high){

            int mid = (low + high)/2;

            // if(array[mid] == target){
            //     return mid;
            // }

            if( array[mid] > target){
                ans = mid;
                high = mid-1;
            }

            else{
                low = mid+1;
            }
        }

        return ans;
    }

    //The Second Optimal Approach without using Lower Bound and Upper Bound
    static void binaryOccrance(int[] array, int target){

        int first = firstOccurance(array, target);
        if(first == -1){
            System.out.println("NO Element Found");
        }
        int last = lastOccurance(array, target);
        System.out.println("(BS) Indexes will be : " + first +" "+ last);
    }


    //For finding the First Occurance
    static int firstOccurance(int[] array, int target){

        int n = array.length;
        int low =0;
        int high =n-1;
        int first =-1;
        
        while(low<=high){

            int mid = (low+high)/2;

            if(array[mid] == target){
                first = mid;
                high = mid-1;
            }

            else if(array[mid] < target){
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }

        return first;
    }

    //Binary search code for finding the last element
    static int lastOccurance(int[] array, int target){
        int n = array.length;
        int low =0;
        int high = n-1;

        int last=-1;

        while(low<=high){

            int mid = (low + high)/2;

            if(array[mid] == target){
                last = mid;
                low = mid+1;
            }

            else if(array[mid] < target){
                low =mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return last;
    }


    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //The Target to search
        int target = input.nextInt();

        //The Bruete Force Approach
        int[] res = brueteForce(array, target);
        for(int i =0; i<res.length; i++){
            System.out.print(res[i] +" ");
        }System.out.println();

        //The Optimal Approach
        optimalApproach(array, target);

        //The Much Optimal Way without Using Lower Bound and Upper Bound
        binaryOccrance(array, target);
    }
}
