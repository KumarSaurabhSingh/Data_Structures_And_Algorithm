import java.util.Scanner;

public class max_NumRows {

    //The Bruete Force Approach
    //Time Complexity: O(n X m), where n = given row number, m = given column number.
    //Space Complexity: O(1) as we are not using any extra space.
    static int brueteForce(int[][] array, int row, int col){

        int index = -1;
        int maxSum =0;

        for(int i=0; i<row; i++){

            int count =0;
            for(int j=0; j<col; j++){
                count = count+ array[i][j];
            }
            if(count > maxSum){
                maxSum = count;
                index =i;
            }
        }

        return index;
    }

    //The Optimal Approach
    //Time Complexity: O(n X logm), where n = given row number, m = given column number.
    //Space Complexity: O(1) as we are not using any extra space.
    static int optimalApproach(int[][] array, int row, int col){

        int maxSum =0;
        int index = -1;

        for(int i=0; i<row; i++){

            int cnt_one = col - binary(array[i], col, 1);

            if(cnt_one > maxSum){
                maxSum = cnt_one;
                index = i;
            }

        }

        return index;
    }

    //Binary Search on the indivial rows to very the number of 1's
    static int binary(int[] array, int row, int limit){

        int low =0;
        int high = row-1;
        int ans =-1;

        while(low <= high){

            int mid = (low+high)/2;

            if(array[mid] >= limit){
                ans =mid;
                high = mid-1;
            }

            else{
                low = mid+1;
            }
        }
        return ans;
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

        //The Bruete Force Approach
        int res = brueteForce(array, row, col);
        System.out.println("The Index with Max: " +res);

        //The Optimal Approach
        int responce = optimalApproach(array, row, col);
        System.out.println("(Optimal) Index with Max: "+ responce);
    }
}
