import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class K_closest_number {

    // Return all the k closest elements to 'x'

    public static void main(String[] args) {

        int[] arr = { 5, 6, 7, 8, 9 };
        int k = 3;
        int x = 7;

        Map<Integer, List<Integer>> map = new HashMap<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (a > b)
                    return -1;
                else if (a < b)
                    return 1;
                return 0;
            }
        });

        for (int i = 0; i < arr.length; i++) {

            int num = Math.abs(arr[i] - x);
            pq.add(num);

            if (pq.size() > k) {
                pq.remove();
            }

            if (!map.containsKey(num)) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                map.put(num, list);
            } else {
                map.get(num).add(arr[i]);
            }
        }
        System.out.println(pq);
        // System.out.println(map);

        while (!pq.isEmpty()) {
            // System.out.print(map.get(pq.poll()) + " ");
            for (int i : map.get(pq.poll())) {
                System.out.print(i + " ");
            }
        }

    }
}
