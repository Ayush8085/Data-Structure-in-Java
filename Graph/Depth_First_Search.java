import java.util.ArrayList;
import java.util.Stack;

public class Depth_First_Search {
    
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

    }

    private static void DFS(ArrayList<Edge>[] graph, int V) {

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        
        while(!stack.isEmpty()) {
            int temp = stack.pop();

            if(!visited[temp]) {
                visited[temp] = true;

                System.out.print(temp+ " ");
                
                for(int i=0; i<graph[temp].size(); i++) {
                    stack.push(graph[temp].get(i).dest);
                }
            }
        }
    }

    private static void RecurrsionDFS(ArrayList<Edge>[] graph, int curr, boolean[] visited) {

        System.out.print(curr+ " ");

        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!visited[e.dest]) {
                RecurrsionDFS(graph, e.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        // DFS(graph, V);

        //----------USING RECURRSION---------
        boolean[] visited = new boolean[V];
        RecurrsionDFS(graph, 0, visited);

        
        //----------FOR BICONNECTED GRAPH------------
        // boolean[] visited = new boolean[V];
        // for(int i=0; i<V; i++) {
        //     if(!visited[i]) {
        //         DFS(graph, V, visited, i);
        //     }
        // }
    }
}
