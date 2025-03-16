import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.
//Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list
public class BFS {

    public static ArrayList<Integer> BFS_Traversal(int vertices, ArrayList<ArrayList<Integer>> adj){

        ArrayList<Integer> BFS = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[vertices];


        visit[0] = true;
        q.add(0);

        while(!q.isEmpty()){

            Integer node = q.poll();
            BFS.add(node);

            for(Integer it : adj.get(node)){
                if(visit[it] == false){
                    visit[it] = true;
                    q.add(it);
                }
            }
        }
        return BFS;
    }
    

    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        
        ArrayList < Integer > ans = BFS_Traversal(5, adj);
        int n = ans.size();

        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
