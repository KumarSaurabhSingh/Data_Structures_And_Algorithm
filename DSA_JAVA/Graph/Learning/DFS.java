import java.util.ArrayList;

//Time Complexity: For an undirected graph, O(N) + O(2E), For a directed graph, O(N) + O(E), Because for every node we are calling the recursive function once, the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.
//Space Complexity: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.




public class DFS {
    
    public static void dfs(int node, boolean[] visit, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> lst){

         //marking current node as visited
        visit[node] = true;
        lst.add(node);

        //getting neighbour nodes
        for(Integer i : adj.get(node)){
            if(visit[i] == false){
                dfs(i, visit, adj, lst);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){

        boolean[] visit = new boolean[V+1];
        visit[0] = true;
        ArrayList<Integer> lst = new ArrayList<>();
        dfs(0, visit, adj, lst);
        return lst;
    }


    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        ArrayList < Integer > ans = dfsOfGraph(5, adj);
        int n = ans.size();
        System.out.println(n);
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
