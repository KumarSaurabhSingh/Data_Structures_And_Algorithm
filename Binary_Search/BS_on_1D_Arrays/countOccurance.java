import java.util.Scanner;

public class countOccurance {

    static void binaryOccrance(int[] array, int target){

        int first = firstOccurance(array, target);
        if(first == -1){
            System.out.println("NO Element Found");
        }
        int last = lastOccurance(array, target);
        int res = last - first +1;
        System.out.println("(BS) Count Occurance will be : " + res);
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

        //The Most Optimal Solution
        binaryOccrance(array, target);
    }
}
