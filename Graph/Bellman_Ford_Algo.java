import java.util.ArrayList;

public class Bellman_Ford_Algo {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    private static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }

    private static void bellmanFordAlgo(ArrayList<Edge>[] graph, int src, int V) {

        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < V - 1; i++) {

            for (int j = 0; j < V; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);

                    if ((dist[e.src] != Integer.MAX_VALUE) && (dist[e.src] + e.wt < dist[e.dest])) {
                        dist[e.dest] = dist[e.src] + e.wt;
                    }
                }
            }
        }

        for (int i : dist) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        bellmanFordAlgo(graph, 0, V);
    }
}
