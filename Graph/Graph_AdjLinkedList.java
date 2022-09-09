import java.util.LinkedList;

public class Graph_AdjLinkedList {
    private LinkedList<Integer>[] adj;
    private int V; // Number of vertices
    private int E; // Number of edges

    Graph_AdjLinkedList(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];

        for(int i=0; i<V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Method to add an edge between two vertices
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    // Method to print vertices and edges
    public void printGraph() {
        System.out.print("\n" +V+ " vertices, " +E+ " edges " +"\n");

        for(int v=0; v<V; v++) {
            System.out.print(v+ " : ");
            for(int w: adj[v]) {
                System.out.print(w+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Graph_AdjLinkedList g = new Graph_AdjLinkedList(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        g.printGraph();
    }
}
