import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Frequency_Sort {

    // Sort the given array on the basis of highest frequency.

    public static void main(String[] args) {

        int[] arr = { 1, 1, 1, 3, 3, 2, 4 };

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]) + 1;
                map.put(arr[i], count);
            } else {
                map.put(arr[i], 1);
            }
        }

        // System.out.println(map);
        Map<Integer, List<Integer>> map1 = new HashMap<>();

        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            int value = map.get(key);

            if (!map1.containsKey(value)) {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                map1.put(value, list);
                pq.add(value);
            } else {
                map1.get(value).add(key);
            }
        }

        // System.out.println(pq);

        int j = 0;
        while (!pq.isEmpty()) {
            int key = pq.poll();
            for (int item : map1.get(key)) {
                for (int i = 0; i < key; i++) {
                    arr[j] = item;
                    j++;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
