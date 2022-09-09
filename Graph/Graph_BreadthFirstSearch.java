import java.util.LinkedList;
import java.util.Queue;

public class Graph_BreadthFirstSearch {
    
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);

        g.printGraph();
        System.out.println();
        g.bfs(0);
    }
}

class Graph {
    private LinkedList<Integer>[] adj;
    private int V;  // number of vertices
    private int E;  // number of edges

    Graph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];

        for(int i=0; i<V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    // Breadth first search method
    public void bfs(int s) {
        boolean[] visited = new boolean[V]; // Check weather a vertice is already visited
        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;

        q.offer(s);
        while(!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u+ " ");

            for(int v: adj[u]) {
                if(!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }

    public void printGraph() {
        System.out.print("\n" +V+ " vertices, " +E+ " edges" + "\n");

        for(int v=0; v<V; v++) {
            System.out.print(v+ " : ");
            for(int w: adj[v]) {
                System.out.print(w+ " ");
            }
            System.out.println();
        }
    }
}