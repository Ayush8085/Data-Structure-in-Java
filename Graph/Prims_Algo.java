import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims_Algo {

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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    private static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int s, int d) {
            this.node = s;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p) {
            return this.dist - p.dist;
        }
    }

    private static void primsAlgo(ArrayList<Edge>[] graph, int V) {

        int cost = 0;
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!visited[curr.node]) {
                visited[curr.node] = true;

                cost += curr.dist;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);

                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        System.out.println(cost);
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        primsAlgo(graph, V);
    }
}
