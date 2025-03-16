import java.util.Scanner;

public class secondLargestElement {

    //Time Complexity will be O(N)
    
    static int secondLargestElement(int[] array){

        int max = array[0];
        for(int i=0; i<array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        return max;
    }

    //check for second largest;
    static int checkSecondLargest(int[] array){
        int max = secondLargestElement(array);

        System.out.println("First Largest Element :   " + max);

        int maxxy =0;
        int count =0;

        for(int i=0; i<array.length; i++){
            if(array[i] >maxxy && array[i] != max){
                maxxy = array[i];
            }
            if(array[i] ==max){
                count ++;
            }
        }

        if(count == array.length){
            return -1;
        }

        else
        return maxxy;
    }


    //Using Quick Sort Method
    //Time complexity = O(N * Log N)
    static void bruteForceMethod(int[] array, int low, int high){
        if(low< high){

            int pivot = pivotIndex(array, low, high);

            bruteForceMethod(array, low, pivot-1);

            bruteForceMethod(array, pivot+1, high);
        }
    }

    //pivot Index method
    static int pivotIndex(int[] array, int low, int high){
        int i=low;
        int j=high;
        int pivot=array[low];

        while(i<j){
            while(array[i] <= pivot && i<=high-1){
                i++;
            }

            while(array[j] >pivot && j>=low+1){
                j--;
            }

            if(i<j){
                int temp=array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        int temp=array[j];
        array[j] = array[low];
        array[low] = temp;

        return j;
    }

    public static void main(String[] args){
        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //Taking input in the array
        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }


        bruteForceMethod(array, 0, arraySize-1);
        int result = array[arraySize-1];

        // for(int i=arraySize-1; i>0; i--){
        //     if(array[i] < result){
        //         System.out.println(array[i]);
        //         break;
        //     }
        // }



        int result1 = checkSecondLargest(array);
        System.out.println("Second Largest Element :  " + result1);
    }
}
