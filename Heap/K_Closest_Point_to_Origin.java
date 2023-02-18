import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class K_Closest_Point_to_Origin {

    // Return all k points which are nearest to the origin when represented on a
    // graph.

    public static void main(String[] args) {

        int[][] arr = {
                { 1, 3 },
                { -2, 2 },
                { 5, 8 },
                { 0, 1 }
        };
        int k = 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int dist = 0;
            for (int j = 0; j < arr[i].length; j++) {
                // Using distance formula
                dist += (arr[i][j] * arr[i][j]);
            }

            for (int j = 0; j < arr[i].length; j++) {

                if (!map.containsKey(dist)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i][j]);
                    map.put(dist, list);
                    pq.add(dist);
                } else {
                    map.get(dist).add(arr[i][j]);
                }
            }

            if (pq.size() > k) {
                pq.remove();
            }
        }

        // System.out.println(map);
        // System.out.println(pq);

        while (!pq.isEmpty()) {
            int key = pq.poll();

            System.out.print(map.get(key) + " ");
        }
    }
}
