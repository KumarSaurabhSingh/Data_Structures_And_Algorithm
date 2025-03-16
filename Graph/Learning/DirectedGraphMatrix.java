import java.util.Arrays;

public class DirectedGraphMatrix {
    int[][] adjMatrix;
    int vertices;


    public DirectedGraphMatrix(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }


    public void addEdge(int u, int v){
        adjMatrix[u][v] = 1;
    }

    public void display(){
        for(int[] row: adjMatrix){
            System.out.println(Arrays.toString(row));
        }
    }


    public static void main(String[] args) {
        DirectedGraphMatrix graph = new DirectedGraphMatrix(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.display();
    }
}
