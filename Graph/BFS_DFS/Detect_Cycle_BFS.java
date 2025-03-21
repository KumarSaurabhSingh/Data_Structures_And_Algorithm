import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Detect_Cycle_BFS {

    public static boolean checkForCycle(ArrayList<ArrayList<Integer>> arr, boolean[] visit, int s, int[] parent){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, -1));
        visit[s] = true;

        while(!q.isEmpty()){

            // source node and its parent node
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            // go to all the adjacent nodes
            for(Integer i : arr.get(node)){

                if(visit[i] == false){

                    q.add(new Node(i, node));
                    visit[i] = true;
                }

                // if adjacent node is visited and is not its own parent node
                else if(par != i) return true;
            }
        }

        return false;
    }



    // function to detect cycle in an undirected graph
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> arr){

        boolean[] visit = new boolean[V];
        Arrays.fill(visit, false);

        int[] parent = new int[V];
        Arrays.fill(parent, -1);


        for(int i=0; i<V; i++){
            if(visit[i] == false){
                if(checkForCycle(arr, visit, i, parent)){
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
