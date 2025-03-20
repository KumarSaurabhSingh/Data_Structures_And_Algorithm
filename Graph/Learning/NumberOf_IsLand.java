import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Pair{
    int num1;
    int num2;

    public Pair(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
}


//Time Complexity ~ O(N² + NxMx9), N² for the nested loops, and NxMx9 for the overall DFS of the matrix, that will happen throughout if all the cells are filled with 1.
//Space Complexity: O(N²) for visited array max queue space O(N²), If all are marked as 1 then the maximum queue space will be N².

public class NumberOf_IsLand {

    public static void BFS(int row, int col, int[][] visit, char[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        visit[row][col] = 1;

        while(!q.isEmpty()){

            int num1 = q.peek().num1;
            int num2 = q.peek().num2;
            q.remove();

            //Traversal through neighbour nodes
            for(int delRow = -1; delRow<=1; delRow++){
                for(int delcol = -1; delcol<=1; delcol++){

                    int nrow = num1 + delRow;
                    int ncol = num2 + delcol;

                     // check if neighbour row and column is valid, and is an unvisited land
                    if(nrow >= 0 && nrow <n && ncol >= 0 && ncol <m &&
                        visit[nrow][ncol] == 0 && arr[nrow][ncol] == '1'){

                        visit[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
    

    public static int numberIsland(char[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int[][] visit = new int[row][col];
        int cnt =0;  //This will count number of Starting Connecting Nodes

        for(int i =0; i<row; i++){

            for(int j=0; j<col; j++){

                if(visit[i][j] == 0 && arr[i][j] == '1'){
                    cnt++;
                    BFS(i, j, visit, arr);
                }
            }
        }

        return cnt;
    }


    public static void main(String[] args)
    {
        char[][] grid =  {
            {'0', '1', '1', '1', '0', '0', '0'},
            {'0', '0', '1', '1', '0', '1', '0'}
        };

        System.out.println("The Number of IsLand: " + numberIsland(grid));
    }
}
