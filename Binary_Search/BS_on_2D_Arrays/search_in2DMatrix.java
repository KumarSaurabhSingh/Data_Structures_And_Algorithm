import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//Problem Statement :- https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/

public class search_in2DMatrix {

    //The Bruete Force Approach
    //Time Complexity: O(N X M), where N = given row number, M = given column number.
    //Space Complexity: O(1) as we are not using any extra space.
    static boolean brueteForce(int[][] array, int row, int col, int search){

        //HashMap<Integer, Integer> temp = new HashMap<>();
        
        for(int i=0; i<row; i++){

            for(int j=0; j<col; j++){
                if(array[i][j] == search){
                    // temp.put(i,j);
                    return true;
                }
            }
        }

        return false;
    }


    //The Better Approach
    //Time Complexity: O(N + logM), where N = given row number, M = given column number.
    //Space Complexity: O(1) as we are not using any extra space.
    static boolean betterApproach(int[][] array, int row, int col, int search){

        for(int i=0; i<row; i++){
            int cnt = binary(array[i], col, search);

            if(cnt == search){
                return true;
            }
        }

        return false;
    }
    //Binary Search for Finding the element
    //Time Complexity - O(Log N)
    static int binary(int[] array, int row, int search){

        int low =0;
        int high = row-1;
        int ans =-1;

        while(low <= high){

            int mid = (low+high)/2;

            if(array[mid] == search){
                ans =mid;
            }

            if(array[mid] > search){
                high = mid-1;
            }

            else{
                low = mid+1;
            }
        }
        return ans;
    }


    //The Optimal Approach
    //Time Complexity: O(log(NxM)), where N = given row number, M = given column number.
    //Space Complexity: O(1) as we are not using any extra space.
    static boolean optimalApproach(int[][] array, int row, int col, int search){

        int low =0;
        int high = row*col -1;

        while(low <= high){

            int mid = (low+ high)/2;

            int row_new = mid/row;

            int col_new = mid%row;

            if(array[row_new][col_new] == search){
                return true;
            }

            else if(array[row_new][col_new] > search){
                high = mid-1;
            }

            else{
                low = mid+1;
            }

        }

        return false;
    }


    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();

        int[][] array = new int[row][col];

        for(int i=0; i<row; i++){

            for(int j=0; j<col; j++){

                array[i][j] = input.nextInt();
            }
        }

        int search = input.nextInt();

        //The Bruete Force Approach
        boolean res1 = brueteForce(array, row, col, search);
        System.out.println("(Bruete) Searched Item Present : "+ res1);

        //The Better Approach
        boolean res2 = brueteForce(array, row, col, search);
        System.out.println("(Better) Searched Item Present : "+ res2);

        boolean res3 = brueteForce(array, row, col, search);
        System.out.println("(Optimal) Searched Item Present : "+ res3);
    }
}
