import java.util.ArrayList;

public class Cycle_Detection_Directed {
    
    // Detect if there exist any cycle in the given Directed graph.

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

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    private static boolean isCycle(ArrayList<Edge>[] graph, boolean[] visited, int curr, boolean[] stack) {

        visited[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (stack[e.dest]) {
                return true;
            } else if (!visited[e.dest]) {
                if (isCycle(graph, visited, e.dest, stack)) {
                    return true;
                }
            }
        }

        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(isCycle(graph, new boolean[V], 0, new boolean[V]));
    }
}
