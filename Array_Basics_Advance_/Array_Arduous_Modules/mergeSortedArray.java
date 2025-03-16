import java.util.Arrays;
import java.util.Scanner;

public class mergeSortedArray {

    //The Bruete Force Approach
    //Time Complexity - O(min(M, N))
    //Space Complexity - O(M + N)
    static void brueteForce(int[] array1, int[] array2){

        int n = array1.length;
        int m = array2.length;
        int left = 0;
        int right = 0;
        int index =0;

        int[] res = new int[m + n];

        while(left <n && right<m){

            if(array1[left] <= array2[right]){
                res[index] = array1[left];
                index++;
                left++;
            }

            else{
                res[index] = array2[right];
                index++;
                right++;
            }
        }

        while(left<n){
            res[index++] = array1[left++];
        }

        while(right<m){
            res[index++] = array2[right++];
        }

        printArray(res);
    }


    //The First Optimal Approach
    //Time Complexity - O(N) + O(N Log N) + O(M Log M)
    //Space Complexity - O(1)
    static void firstOptimal(int[] array1, int[] array2){
        int n = array1.length;
        int m = array2.length;

        int left = n-1;
        int right = 0;

        while(left >= 0 && right < m){
            if(array1[left] > array2[right]){
                int temp = array1[left];
                array1[left] = array2[right];
                array2[right] = temp;
                left--;
                right++;
            }

            else{
                left--;
                right++;
                continue;
                //break;
            }
        }

        Arrays.sort(array1);
        Arrays.sort(array2);

        printArray(array1);
        System.out.println();
        printArray(array2);
    }



    //Second Optimal Approach --> Shell Sorting Method
    //Time Complexity: O((n+m)*log(n+m)), where n and m are the sizes of the given arrays.
    //Space Complexity: O(1) as we are not using any extra space.
    static void secondOptimal(int[] array1, int[] array2){

        int n = array1.length;
        int m = array2.length;

        int length = m+n;
        int gap = (length/2) + length%2;

        while(gap>0){

            int left =0;
            int right = gap+left;

            while(right <length){
                //Left and right in different arrays
                if(left <n && right >=n){

                    //System.out.println("array1 before : " + array1[left]);
                    swapElements(array1, array2, left, right-n);

                    //System.out.println("array1 after : " + array1[left]);
                }

                //left and right in array1
                else if( left >=n ){
                    swapElements(array2, array2, left-n, right-n);
                }
                //left and right in array2
                else{
                    swapElements(array1, array1, left, right);
                }

                left++;
                right++;
            }
            if(gap ==1){
                break;
            }
            //System.out.println("Value of Gap : "+gap);
            gap = gap/2 + gap%2;
        }

        printArray(array1);
        System.out.println();
        printArray(array2);

    }

    static void swapElements(int[] array1, int[] array2, int idx1, int idx2){

        if(array1[idx1] > array2[idx2]){

            int temp = array2[idx2];
            array2[idx2] = array1[idx1];
            array1[idx1] =temp;
        }
    }

    
    public static void main(String[] args){

        //First Array Input
        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];

        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //Second Array Input
        int arraySize2 = input.nextInt();

        int[] array2 = new int[arraySize2];

        for(int i=0; i<arraySize2; i++){
            array2[i] = input.nextInt();
        }

        //The Bruete Force Approach
        //brueteForce(array, array2);

        //The First Optimal Approach
        //firstOptimal(array, array2);

        //The Second Optimal Approach
        secondOptimal(array, array2);
    }

    //Printing the array
    static void printArray(int[] array){

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
