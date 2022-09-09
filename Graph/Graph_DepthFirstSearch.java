import java.util.LinkedList;
import java.util.Stack;

public class Graph_DepthFirstSearch {
    
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);

        g.printGraph();
        System.out.println();
        g.dfs(0);
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

    // Depth first search method
    public void dfs(int s) {
        boolean[] visited = new boolean[V]; // Check weather a vertice is already visited
        Stack<Integer> stack = new Stack<>();

        stack.push(s);
        while(!stack.isEmpty()) {
            int u = stack.pop();
            if(!visited[u]) {
                visited[u] = true;
                System.out.print(u+ " ");
                for(int v: adj[u]) {
                    if(!visited[v]) {
                        stack.push(v);
                    }
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