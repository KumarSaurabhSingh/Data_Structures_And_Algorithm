import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class fourSum {

    //The Burete Force Approach (Naive Approach)
    //Time Complexity: O(N4), where N = size of the array.
    //Space Complexity: O(2 * no. of the quadruplets) as we are using a set data structure and a list to store the quads.
    static List<List<Integer>> brueteForce(int[] array){

        int n = array.length;

        Set<List<Integer>> ans = new HashSet();

        for(int i=0; i<n; i++){

            for(int j=i+1; j<n; j++){

                for(int k =j+1; k<n; k++){

                    for(int l=k+1; l<n; l++){

                        int sum = array[i] + array[j] + array[k];
                        sum = sum + array[l];

                        if(sum == 0){
                            List<Integer> temp = Arrays.asList(array[i], array[j], array[k], array[l]);

                            temp.sort(null);
                            ans.add(temp);
                        }
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
    }
    
    


    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];

        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //The Bruete Force Approach
        List<List<Integer>> res = brueteForce(array);

        for(List<Integer> It : res){

            System.out.print("[");

            for(Integer i : It){
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
}
