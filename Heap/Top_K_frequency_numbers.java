import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_frequency_numbers {

    // Return all k elements from the array with highest frequeny.

    public static void main(String[] args) {

        int[] arr = { 1, 1, 1, 3, 2, 2, 4 };
        // int[] arr = { 1, 1, 1, 3, 3, 3, 2, 2, 4 };
        int k = 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]) + 1;
                map.put(arr[i], count++);
            } else {
                map.put(arr[i], 1);
            }
        }

        Map<Integer, List<Integer>> map1 = new HashMap<>();

        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            int value = map.get(key);

            // pq.add(value);

            if (!map1.containsKey(value)) {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                map1.put(value, list);
                pq.add(value);
            } else {
                map1.get(value).add(key);
            }

            if (pq.size() > k) {
                pq.remove();
            }

        }
        // System.out.println(pq);
        // System.out.println(map1);

        List<Integer> list1 = new ArrayList<>();
        while (!pq.isEmpty()) {
            int key = pq.poll();
            for (int i : map1.get(key)) {
                list1.add(i);
            }
        }

        // System.out.println(list1);

        Collections.reverse(list1);
        for (int i = 0; i < 2; i++) {
            System.out.print(list1.get(i) + " ");
        }
    }
}
