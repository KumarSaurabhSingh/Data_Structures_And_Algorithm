import java.util.LinkedList;
import java.util.Queue;

class Node{
    int num1;
    int num2;
    int num3;

    public Node(int num1, int num2, int num3){
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }
}

public class Nearest_Cell {

    public static int[][] nearest(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int visit[][] = new int[n][m];
        int dist[][] = new int[n][m];
        Queue<Node> q = new LinkedList<Node>();
        //Updating the visited arr;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1){
                    q.add(new Node(i, j, 0));
                    visit[i][j] = 1;
                }else{
                    visit[i][j] = 0;
                }
            }
        }


        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().num1;
            int col = q.peek().num2;
            int step = q.peek().num3;

            q.remove();
            dist[row][col] = step;

            //Checking for all 4 neighbours
            for(int i=0; i<4; i++){

                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                // check for valid unvisited cell
                if(nrow >=0 && nrow <n && ncol >= 0 && ncol<m && visit[nrow][ncol] == 0){
                    visit[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol, step + 1));
                }
            }
        }

        return dist;

    }
    
    public static void main(String[] args) {
        int[][] grid = {
            {0,1,1,0},
            {1,1,0,0},
            {0,0,1,1}
        };

        int[][] ans = nearest(grid);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
