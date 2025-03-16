import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class asteroid_Collison {

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    static List<Integer> collison(int[] arr){
        int n = arr.length;

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){

            boolean destructor = false;
                while(!list.isEmpty()  && list.get(list.size() - 1) > 0 && arr[i]<0){
                    
                    int top = list.get(list.size() - 1);


                    if(Math.abs(top) < Math.abs(arr[i])){ //removing the elements of less than arr[i]
                        list.remove(list.size() - 1);
                        continue;
                    }

                    else if(Math.abs(top) == Math.abs(arr[i])){
                        list.remove(list.size() - 1);
                    }

                    destructor = true;
                    break;
                }

            if(!destructor){
                list.add(arr[i]);
            }
        }

        return list;
    }
    

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int[] arr = new int[size];

        for(int i =0; i< size; i++){
            arr[i] = input.nextInt();
        }

        List<Integer> ans = collison(arr);

        for(Integer i : ans){
            System.out.print(i + " ");
        }
    }
}
