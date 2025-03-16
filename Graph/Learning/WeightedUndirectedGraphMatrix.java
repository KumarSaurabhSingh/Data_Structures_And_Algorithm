import java.util.Arrays;

class WeightedUndirectedGraphMatrix {
    private int[][] adjMatrix;
    private int vertices;

    public WeightedUndirectedGraphMatrix(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int u, int v, int weight) {
        adjMatrix[u][v] = weight;
        adjMatrix[v][u] = weight;
    }

    public void display() {
        for (int[] row : adjMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        WeightedUndirectedGraphMatrix graph = new WeightedUndirectedGraphMatrix(4);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 7);
        graph.display();
    }
}
