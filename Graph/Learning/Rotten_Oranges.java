import java.util.LinkedList;
import java.util.Queue;


//Time Complexity: O ( n x n ) x 4
//Space Complexity: O ( n x n )
public class Rotten_Oranges {

    public static int orangesRotting(int[][] arr){

        if(arr == null || arr.length == 0) return 0;

        int n = arr.length;
        int m = arr[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;

        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){

                if(arr[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }

                if(arr[i][j] == 1){
                    count_fresh++;
                }
            }
        }


        //If there is no fresh-Oranges
        if(count_fresh == 0){
            return 0;
        }
        int countMin = 0, cnt = 0;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

         //bfs starting from initially rotten oranges
        while(!queue.isEmpty()){
            int size = queue.size();
            cnt+=size;

            for(int i=0; i<size; i++){
                int[] temp = queue.poll();
                for(int j=0; j<4; j++){
                    int delX = dx[j] + temp[0];
                    int delY = dy[j] + temp[1];


                    if(delX < 0 || delX >= n || delY < 0 || delY >= m || arr[delX][delY] == 0 || arr[delX][delY] == 2){

                        continue;
                    }

                    arr[delX][delY] = 2;

                    queue.offer(new int[]{delX, delY});
                }
            }


            if(queue.size() != 0){
                countMin++;
            }
        }

        return countMin == cnt ? countMin : -1;
    }
    

    public static void main(String args[])
    {
        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);
    }
}
