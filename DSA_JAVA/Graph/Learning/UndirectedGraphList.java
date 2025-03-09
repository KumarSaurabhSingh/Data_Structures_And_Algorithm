import java.util.ArrayList;
import java.util.List;

//Time Complexity - O(N)
//SPace Complexity - O(N)
public class UndirectedGraphList {

    private List<List<Integer>> adjList;
    private int vertices;
    
    public UndirectedGraphList(int vertices){
        adjList = new ArrayList<>();
        for(int i=0; i< vertices; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void display(){
        for(int i =0; i< adjList.size(); i++){
            System.out.println(i + " --> "+ adjList.get(i));
        }
    }


    public static void main(String[] args) {
        UndirectedGraphList graph = new UndirectedGraphList(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.display();
    }
}
