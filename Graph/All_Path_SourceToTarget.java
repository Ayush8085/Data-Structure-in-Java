import java.util.ArrayList;

public class All_Path_SourceToTarget {

    // Print all the possible paths from source to the target from the graph

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

    private static void AllPathSourceToTarget(ArrayList<Edge>[] graph, boolean[] visited, int curr, String path,
            int target) {
        if (curr == target) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            if (!visited[curr]) {
                visited[curr] = true;
                AllPathSourceToTarget(graph, visited, graph[curr].get(i).dest, path + graph[curr].get(i).dest, target);
                visited[curr] = false;
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        AllPathSourceToTarget(graph, new boolean[V], 0, "0", 5);
    }
}
