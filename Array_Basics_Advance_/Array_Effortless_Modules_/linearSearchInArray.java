import java.util.Scanner;

public class linearSearchInArray {

    //Printing an Array
    static void printArray(int array[]){
        for(int i=0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    
    static boolean linearSearchInArray(int[] array, int num){

        for(int i=0; i<array.length; i++){
            if(array[i] == num){
                return true;
            }
        }
        return false;
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

        int num = input.nextInt();

        //int res = linearSearchInArray(array, num);

        System.out.println(linearSearchInArray(array, num));

        // if(res >-1){
        //     System.out.println("Found at Index   " + res);
        // }

        // else{
        //     System.out.println("Not Found");
        // }
    }
}
