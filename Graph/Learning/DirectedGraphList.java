import java.util.ArrayList;
import java.util.List;
public class DirectedGraphList {
    List<List<Integer>> adjList;
    int vertices;

    public DirectedGraphList(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList<>();

        for(int i=0; i<vertices; i++){
            adjList.add(new ArrayList<>());  //Creating new list under a list for each node
        }
    }


    public void addEdge(int u, int v){
        adjList.get(u).add(v);
    }


    public void display(){
        for(List<Integer> list : adjList){
            System.out.println(list);
        }
    }


    public static void main(String[] args) {
        DirectedGraphList graph = new DirectedGraphList(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.display();
    }
}
