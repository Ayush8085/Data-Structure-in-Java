public class Graph_AdjMatrix {

    private int V;
    private int E;
    private int[][] adjMatrix;

    Graph_AdjMatrix(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        E++;
    }

    // Method to print all the vertices and edges in String form
    public void printString() {
        System.out.print("\n" + V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            System.out.print("\n" + v + " :");
            for (int w : adjMatrix[v]) {
                System.out.print(w + " ");
            }
        }
    }

    public static void main(String[] args) {

        Graph_AdjMatrix g = new Graph_AdjMatrix(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.printString();
    }
}
