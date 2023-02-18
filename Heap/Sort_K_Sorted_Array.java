import java.util.PriorityQueue;

public class Sort_K_Sorted_Array {

    // Given a nearly-sorted array, sort this array.

    public static void main(String[] args) {

        int[] arr = { 6, 5, 3, 2, 8, 10, 9 };
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            pq.add(arr[i]);

            if (pq.size() > k) {
                arr[j] = pq.poll();
                j++;
            }
        }

        while (!pq.isEmpty()) {
            arr[j] = pq.poll();
            j++;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
