import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth_smallest_element {

    // Return the Kth smallest element from the given array.

    public static void main(String[] args) {

        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int k = 3;

        // Comparator is used here to reverse the order in which the elements are stored
        // in the priority queue.
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

            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        System.out.println(pq.peek());
    }
}