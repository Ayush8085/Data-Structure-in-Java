import java.util.ArrayList;
import java.util.Stack;

public class Kosarajus_Algo {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    private static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    private static void topologicalSort(ArrayList<Edge>[] graph, int curr, Stack<Integer> stack,
            boolean[] visited) {

        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visited[e.dest]) {
                topologicalSort(graph, e.dest, stack, visited);
            }
        }

        stack.push(curr);
    }

    private static void DFS(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        visited[curr] = true;

        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visited[e.dest]) {
                DFS(graph, e.dest, visited);
            }
        }
    }

    private static void kosarajuAlgo(ArrayList<Edge>[] graph, int V) {
        // ---------------STEP 1-----------
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(graph, i, stack, visited);
            }
        }

        // ---------------STEP 2-----------
        ArrayList<Edge>[] transpose = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false; // for reusing the same visited array.
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);

                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // ---------------STEP 3-----------
        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (!visited[curr]) {
                DFS(transpose, curr, visited);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        kosarajuAlgo(graph, V);
    }
}
