import java.util.Scanner;

public class rotateAnArray {

    //The only optimal solution

    static int[] rotateAnArray(int[] array){

        int temp = array[0];

        for(int i=1; i<array.length; i++){
            array[i-1] = array[i];
        }

        array[array.length-1] = temp;

        return array;
    }


    //rotate by right
    static int[] rotateByRight(int[] array){

        int temp = array[array.length-1];

        for(int i=array.length-1; i>0; i--){
            array[i] = array[i-1];
        }

        array[0] = temp;

        return array;
    }

    static void printArray(int array[]){
        for(int i=0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    static int[] multipleRotate(int[] array, int mul){

        while(mul>0){
            rotateAnArray(array);
            mul--;
        }
        return array;
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

        //rotateAnArray(array);
        //System.out.print("Rotated Array is : ");
        //printArray(array);

        //multipleRotate(array, 4);
        rotateByRight(array);
        printArray(array);
    }


    //Another Optimal approach
    //Time complexity - O(n)
    //Space complexity - O(1)
    public void rotate(int[] nums, int k) {
        // Optimize k to prevent unnecessary rotations
        k = k % nums.length;

        // Edge case: If k is 0 or nums.length is 1, no rotation is needed
        if (k == 0 || nums.length == 1) return;

        // Step 1: Reverse the entire array
        reverse(nums, 0, nums.length - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap the elements at start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
