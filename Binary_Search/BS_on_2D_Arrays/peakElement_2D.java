import java.util.Arrays;
import java.util.Scanner;

public class peakElement_2D {

    static int maxElement(int[][] array, int row, int col, int col_new){
        int maxi = Integer.MIN_VALUE;
        int index =-1;
        for(int i=0; i<row; i++){
            if(array[i][col_new] > maxi){
                maxi = array[i][col_new];
                index = i;
            }
        }
        //System.out.println("Max Element : "+ array[index][col_new]);

        return index;
    }

    
    //The Optimal Approach
    //Time Complexity - O(log N * M)
    //Space Complexity - O(1)
    static int[] optimalApproach(int[][] array, int row, int col){
        int low = 0;
        int high = col-1;

        while(low <= high){

            int mid = (low+high)/2;

            int maxi_Element = maxElement(array, row, col, mid);

            int left = mid-1 >= 0 ? array[maxi_Element][mid-1] : -1;
            int right = mid+1 < col ? array[maxi_Element][mid+1] : -1;

            if(array[maxi_Element][mid] > left && array[maxi_Element][mid] > right){
                return new int[]{maxi_Element, mid};
            }

            else if(array[maxi_Element][mid] <left){
                high = mid-1;
            }

            else{
                low = mid+1;
            }

        }

        return new int[]{-1, -1};
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

        //The Optimal Approach
        int[] res = optimalApproach(array, row, col);
        System.out.println(Arrays.toString(res));
    }
}

