import java.util.Scanner;

public class singleElementSortedArr {

    static int singleElementSortedArr(int[] array){

        int n = array.length;
        int low = 0;
        int high = n-1;

        if(n==1) return array[0];

        if(array[0] != array[1]) return array[0];
        if(array[n-1] != array[n-2]) return array[n-1];

        while(low <= high){

            int mid = (low + high)/2;

            if(array[mid] != array[mid +1] && array[mid] != array[mid -1]){
                return array[mid];
            }

            if((mid %2 == 1 && array[mid] == array[mid -1]) || ( mid %2 ==0 && array[mid] == array[mid +1])){

                low = mid+1;
            }
            /*
            If (i % 2 == 0 and arr[i] == arr[i+1]) or (i%2 == 1 and arr[i] == arr[i-1]), we are in the left half.
            If (i % 2 == 0 and arr[i] == arr[i-1]) or (i%2 == 1 and arr[i] == arr[i+1]), we are in the right half.
            */

            else {
                high=mid-1;
            }
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

        int res = singleElementSortedArr(array);
        System.out.println("Unique Value is : "+res);
    }
}
