import java.util.ArrayList;
import java.util.Scanner;

public class leaderInArray {

    //Bruete Force Approach
    //Time Complexity - O(N^2)
    //Space Complexity - O(N) - This space is used to store the result not to generate
    static void brueteForce(int[] array){
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<array.length; i++){
            int count =0;

            for(int j=i+1; j<array.length; j++){

                if(array[j] > array[i]){
                    count++;

                }
            }

            if(count ==0){
                ans.add(array[i]);
            }
        }

        System.out.println(ans);
    }

    //Optimal Approach
    //Time Complexity - O(N)
    //Space Complexity - O(N) - Just to store the answer not to generate
    static void optimalApproach(int[] array){
        int max = Integer.MIN_VALUE;

        int n = array.length;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=n-1; i>=0; i--){
            if(array[i] >= max){
                max = array[i];
                ans.add(array[i]);
            }
        }

        System.out.println(ans);
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

        //Bruete Force Approach
        //brueteForce(array);

        //Optimal Approach
        optimalApproach(array);
    }
}
