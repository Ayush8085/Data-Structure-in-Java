import java.util.LinkedList;

public class Graph_DFS_recursion {
    
    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        // g.addEdge(0);

        g.printGraph();
        System.out.println();
        g.dfs();
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

    // public void addEdge(int u) {
    //     adj[u].add(u);
    // }

    // Depth first search method
    public void dfs() {
        boolean[] visited = new boolean[V];
        for(int v=0; v<V; v++) {
            if(!visited[v]) {
                dfs(v, visited);
            }
        }
    }

    public void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v+ " ");
        for(int w: adj[v]) {
            if(!visited[w]) {
                dfs(w, visited);
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