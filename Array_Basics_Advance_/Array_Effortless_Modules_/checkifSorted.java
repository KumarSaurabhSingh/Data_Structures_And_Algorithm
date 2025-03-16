import java.util.Scanner;

/*https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/ */

public class checkifSorted {

    //Time Complexity will be O(N)
    //space complexity will be O(1)

    static boolean checkifSorted(int[] array){
        int count =0;
        int size = array.length;

        for(int i=0; i<size-1; i++){
            if(array[i] > (array[i+1]))
            count ++;
        }


         // If there is more than 1 drop, it's not a valid rotation
        if (count > 1) {
            return false;
        }

        // If there is exactly 1 drop, check if the array after the drop is sorted
        if (count == 1) {
            // Check if the array after the drop is sorted
            // After a drop, the array should wrap around and continue being sorted
            return array[0] >= array[size - 1];

            /*For the array {3, 4, 5, 1, 2}, there is a drop at 5 > 1, and the rest of the array is sorted.
            The condition array[0] >= array[n - 1] (i.e., 3 >= 2) holds true.
            So this is a valid rotation of the sorted array [1, 2, 3, 4, 5]. */
        }

        // If no drops, the array is already sorted
        return true;
    }

    /*Zero drops (count == 0):

    If count == 0, it means that the array is already sorted in non-decreasing order with no "wrap-around." In other words, the array was never rotated and is already in its original sorted state.
    Example: [1, 2, 3, 4, 5] → No drops, so it's a valid rotation with x = 0 (no rotation).
    One drop (count == 1):

    If count == 1, it means that there is exactly one drop in the array. This typically happens when the array was originally sorted and then rotated at the point where the largest element of the sorted array wraps around to the front.
    This is a valid rotated sorted array because a single drop implies that the array is sorted but was "shifted" in such a way that the largest element was moved to the front, and the rest of the elements followed.
    Example: [3, 4, 5, 1, 2] → One drop at 5 > 1, but the rest are in sorted order. This is a valid rotation (rotated by 3 positions).
    More than one drop (count > 1):

    If there are more than one drop, it means that the array cannot be a valid rotation of a sorted array. There is more than one point where the array is descending, which breaks the property of the array being rotated from a sorted state.
    Example: [2, 1, 3, 4] → There is a drop at 2 > 1 but also at 3 > 4. More than one drop means the array isn't a valid rotation of a sorted array, so we return false.
    */
    
    public static void main(String[] args){
        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //Taking input in the array
        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        System.out.print(checkifSorted(array));

    }
}
