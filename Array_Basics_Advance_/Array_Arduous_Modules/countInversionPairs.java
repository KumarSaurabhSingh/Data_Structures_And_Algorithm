import java.util.ArrayList;
import java.util.Scanner;

public class countInversionPairs {

    //The Bruete Force Approach
    //Time Complexity: O(N2), where N = size of the given array.
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.
    static void brueteForce(int[] array){

        int n = array.length;
        int count =0;

        for(int i=0; i<n; i++){

            for(int j=i+1; j<n; j++){

                if(array[i] > 2 * array[j]){
                    count++;
                }
            }
        }

        System.out.println("The Total Inversion Pair are : "+count);
    }


    //The Optimal Approach
    //Time Complexity: O(2N*logN), where N = size of the given array.
    //Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.
    static void optimalApproach(int[] array){

        int n =array.length;
        int result = mergeSort(array, 0, n-1);
        System.out.println("Inversion Pairs are (Optimal) : "+result);
    }

    //The Merge Sort Alogorithm
    static int mergeSort(int[] array, int low, int high){
        int count =0;

        if(low >= high){
            return count;
        }

        int mid = (low + high)/2;

        //The first half
        count += mergeSort(array, low, mid);

        //The Second Half
        count += mergeSort(array, mid+1, high);

        //Checking for the point check
        count += countPairs(array, low, mid, high);

        merge(array, low, mid, high);

        return count;
    }


    //Checking for the count pairs
    static int countPairs(int[] array, int low, int mid, int high){

        int count =0;
        int right = mid+1;
        for(int i=low; i<=mid; i++){

            while(right <= high && array[i] > 2 * array[right]){
                right++;
            }
            count += (right - (mid +1));

            
        }
        return count;
    }


    static void merge(int[] array, int low, int mid, int high){

        ArrayList<Integer> Temp = new ArrayList<>(); // temporary array
        int left = low; // starting index of left half of arr
        int right = mid +1;  // starting index of right half of arr


        //storing elements in the temporary array in a sorted manner//

        while (left<= mid && right <= high ){

            if(array[left] <=array[right]){
                Temp.add(array[left]);
                left++;
            }

            else{
                Temp.add(array[right]);
                right++;
            }
        }

        // if elements on the left half are still left //
        while(left <= mid){
            Temp.add(array[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while(right <=high){
            Temp.add(array[right]);
            right++;
        }

         // transfering all elements from temporary to arr //
        for(int i= low; i<=high; i++){
            array[i] = Temp.get(i-low);
        }

    }



    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];

        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //The Bruete Force Approach
        brueteForce(array);

        //The Optimal Approach
        optimalApproach(array);
    }
}
