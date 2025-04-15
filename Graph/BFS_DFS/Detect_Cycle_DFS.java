import java.util.ArrayList;


//Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.
//Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and visited array.
public class Detect_Cycle_DFS {

    private static boolean dfs(int node, int parent, int[] visit, ArrayList<ArrayList<Integer>> arr) {
        
        visit[node] = parent;

        // go to all adjacent nodes
        for(Integer adjNode : arr.get(node)){

            if(adjNode == 0){
                if(dfs(adjNode, node, visit, arr) == true){
                    return true;
                }
            }

            // if adjacent node is visited and is not its own parent node
            else if(adjNode != parent){
                return true;
            }
        }

        return false;
    }
    

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> arr){
        int[] visit = new int[V];

        for(int i=0; i<V; i++){

            if(visit[i] == 0){
                if( dfs(i, -1, visit, arr) == true){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
                
        boolean ans = isCycle(4, adj);
        if (ans)
            System.out.println("Loop Detected !");
        else
            System.out.println("No Loop Detected !!");
    }
}
