import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class removeDuplicatesArray {

    //Bruete force method
    //Time complexity: O(n*log(n))+O(n)
    //Space Complexity: O(n)
    static int removeDuplicatesArray(int[] array){

        Set<Integer> element = new HashSet<>();

        for(int i=0; i<array.length; i++){
            if(element.contains(array[i])){

            }
            else{
                element.add(array[i]);
            }
        }

        //System.out.println(element);

        int k = element.size();
        int j = 0;
        for (int x: element) {
            array[j++] = x;
        }
        return k;
    }
    

    //Optimal Approach -> Two pointer approach
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    static int removeArrayDuplicates(int[] arr){

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    } //Only be used if the array is already sorted

    //Sorting of an array using Insertion sort
    static int[] sortArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            int j=i;
            while(j>0 && arr[j] < arr[j-1]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }

        return arr;
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
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

        int[] arr =  sortArray(array);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        //For bruete for method
        //int result = removeDuplicatesArray(array);

        System.out.println();
        //For optimal approach
        int result = removeArrayDuplicates(arr);
        for (int i = 0; i < result; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
