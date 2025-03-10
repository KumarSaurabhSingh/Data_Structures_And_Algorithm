import java.util.ArrayList;
import java.util.List;
class WeightedUndirectedGraphList {
    private List<List<int[]>> adjList;

    public WeightedUndirectedGraphList(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new int[]{v, weight});
        adjList.get(v).add(new int[]{u, weight});
    }

    public void display() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            for (int[] edge : adjList.get(i)) {
                System.out.print("[" + edge[0] + "," + edge[1] + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WeightedUndirectedGraphList graph = new WeightedUndirectedGraphList(4);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 7);
        graph.display();
    }
}
