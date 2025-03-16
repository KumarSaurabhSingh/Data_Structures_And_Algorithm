// Question link :- https://www.geeksforgeeks.org/problems/reverse-an-array/0

public class gfg_reverseAnArray {

    
        public void reverseArray(int arr[]) {
            reverseHelper(arr, 0, arr.length - 1);
        }
        
        // Helper function for recursion
        private void reverseHelper(int arr[], int left, int right) {
            if (left >= right) {
                return; // Base case: stop when left meets or exceeds right
            }
            
            // Swap the elements at indices `left` and `right`
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            // Recursive call with updated indices
            reverseHelper(arr, left + 1, right - 1);
        }
    
    
}
