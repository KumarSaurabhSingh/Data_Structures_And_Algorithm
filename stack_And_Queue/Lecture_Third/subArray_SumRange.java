import java.util.Scanner;

public class subArray_SumRange {

    static int brueteForce(int[] arr){

        int n = arr.length;
        int sum = 0;

        for(int i=0; i<n; i++){
            int largest = arr[i];
            int smallest = arr[i];

            for(int j=i+1; j<n; j++){
                largest = Math.max(largest, arr[j]);
                smallest = Math.min(smallest, arr[j]);

                sum = sum + (largest - smallest);
            }
        }

        return sum;
    }
    

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int[] arr = new int[size];

        for(int i =0; i< size; i++){
            arr[i] = input.nextInt();
        }


        int brueteAns = brueteForce(arr);
        System.out.println("Sum : "+ brueteAns);
    }
}
