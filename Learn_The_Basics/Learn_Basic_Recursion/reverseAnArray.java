import java.util.Scanner;

public class reverseAnArray {

    static void printArray(int arr[], int n) {
        System.out.print("Reversed array is:- \n");
        for (int i = 0; i < n; i++) {
        System.out.print(arr[i] + " ");
        }
    }
    
    static void reverseAnArray(int arr[],int start, int end){

        if(start>= end){
            return;
        }
            
        
            int temp = arr[end-1];
            arr[end-1] = arr[start];
            arr[start] = temp;

            reverseAnArray(arr, start+1, end-1); 
    }

    public static void main(String[] args){
        int n;
        Scanner input = new Scanner(System.in);
        n=input.nextInt();

        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            // if(input.hasNextInt())
            arr[i] = input.nextInt();
        }
        //printArray(arr, n);
        reverseAnArray(arr, 0, n);
        printArray(arr, n);
    }
}
