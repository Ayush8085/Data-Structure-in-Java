import java.util.ArrayList;
import java.util.Stack;

public class Topological_Sort {
    
    // This sorting is done in Directed acyclic graph (graph having direction and no cycles)

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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    private static void TopologicalSortUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, Stack<Integer> stack) {
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!visited[e.dest]) {
                TopologicalSortUtil(graph, visited, e.dest, stack);
            }
        }
        stack.push(curr);
    }

    private static void TopologicalSort(ArrayList<Edge>[] graph, int V) {

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                TopologicalSortUtil(graph, visited, i, stack);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+ " ");
        }
    }

    public static void main(String[] args) {
        
        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        TopologicalSort(graph, V);
    }
}
