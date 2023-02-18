import java.util.PriorityQueue;

public class K_largest_element {

    // Return the all the K largest element from the given array.

    public static void main(String[] args) {

        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {

            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        System.out.println(pq);
    }
}
