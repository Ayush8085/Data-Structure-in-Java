import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Max_of_all_subarrays {

    // Return the maximum integer from all the subarrays of size k.

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        int start = 0;
        int end = 0;

        q.add(arr[0]);

        ArrayList<Integer> list = new ArrayList<>();

        while (end < arr.length) {

            if (arr[end] >= q.peek()) {
                q.clear();
            }

            q.add(arr[end]);

            if ((end - start + 1) < k) {
                end++;
            } else {
                list.add(q.peek());

                if (arr[start] == q.peek()) {
                    q.remove();
                }

                start++;
                end++;
            }

        }

        for (int item : list) {
            System.out.print(item + " ");
        }
    }
}
