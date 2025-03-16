import java.util.Scanner;

public class maxConsecutive {

    //The only approach
    //Time Complexity - O(N)
    //Space Complexity - O(1)

    static void maxConsecutive(int[] array){
        int size = array.length;
        int count =0;
        int max =0;

        for(int i=0; i<array.length; i++){

            if(array[i] ==1){
                count ++;
            }

            else{
                count =0;
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
    
    public static void main(String[] args){

        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //Taking input in the array
        int[] array = new int[arraySize-1];
        for(int i=0; i<arraySize-1; i++){
            array[i] = input.nextInt();
        }

        maxConsecutive(array);
    }
}
