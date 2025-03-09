import java.util.Arrays;

//Time Complexity - O(N)
//Time Complexity - O(N*N)
public class UndirectedGraphMatrix {

    private int[][] adjMatrix;
    private int vertices;

    public UndirectedGraphMatrix(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices]; // Default is 0
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1; // Mark edge from u to v
        adjMatrix[v][u] = 1; // Since undirected, mark v to u as well
    }

    public void display() {
        for (int[] row : adjMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        UndirectedGraphMatrix graph = new UndirectedGraphMatrix(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.display();
    }
    
}
