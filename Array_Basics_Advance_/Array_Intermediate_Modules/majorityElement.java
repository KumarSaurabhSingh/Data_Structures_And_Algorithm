import java.util.Scanner;

public class majorityElement {

    static void optimalApproach(int[] array){

        int count =0;
        int temp = 0;  //temp element
        for(int i=0; i<array.length; i++){

            if(count ==0){
                count ++;
                temp = array[i];
            }

            else if(array[i] == temp){
                count++;
            }

            else{
                count --;
            }
        }

        int cnt =0;
        for(int i=0; i<array.length; i++){

            if(array[i] == temp){
                cnt++;
            }
        }

        if(cnt > (array.length)/2){
            System.out.println("Majority Element will be " + temp);
        }

        else{
            System.out.println("NOT FOUND");
        }
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

        //Optimal Approach
        optimalApproach(array);
    }
}
