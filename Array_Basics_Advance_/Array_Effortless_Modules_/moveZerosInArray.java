import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class moveZerosInArray {

    //Printing an Array
    static void printArray(int array[]){
        for(int i=0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }
    }


    //Bruete force approach
    //Time Complexit - O(2N)
    //Space Complexity - O(N) - For worst case
    
    static void bruete_moveZerosInArray(int[] array){

        List<Integer> element = new ArrayList<>();

        for(int i=0; i<array.length; i++){

            if(array[i] != 0){
                element.add(array[i]);
            }
        }

        //Iterating in the temp set amd updating all of the non sero numbers in the current array
        for(int i=0; i<element.size(); i++){
            if(i<=element.size()){
                array[i] = element.get(i);
            }
        }

        //Filling the zeros at the end of the arrat
        int n= element.size();
        for(int i=n; i<array.length; i++ ){
            array[i] = 0;
        }

    }

    //Optimal Approcah for the above case
    //Time complexity - O(N) + O(N-X) = O(N)
    //Space Complexity - O(1)
    static void optimalMoveZero(int[] array){

        int j=-1;
        for(int i=0; i<array.length; i++){
            if(array[i] ==0){
                j=i;
                break;
            }
        }//Taking the very first zero value index
        //Time complexit - O(X)

        //Moving all of the zero elements at the end of the sequence
        for(int i=j+1; i<array.length; i++){

            if(array[i] !=0){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
        }
        //Time complexity - O(N-X)
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

        //bruete_moveZerosInArray(array);
        optimalMoveZero(array);
        printArray(array);
    }
}
