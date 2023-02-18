import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Breadth_First_Search {

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

    private static void BFS(ArrayList<Edge>[] graph, int V) {

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while(!q.isEmpty()) {
            int temp = q.remove();

            if(!visited[temp]) {
                visited[temp] = true;

                System.out.print(temp+ " ");

                for(int i=0; i<graph[temp].size(); i++) {
                    q.add(graph[temp].get(i).dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        BFS(graph, V);

        //----------FOR BICONNECTED GRAPH------------
        // boolean[] visited = new boolean[V];
        // for(int i=0; i<V; i++) {
        //     if(!visited[i]) {
        //         BFS(graph, V, visited, i);
        //     }
        // }
    }
}
