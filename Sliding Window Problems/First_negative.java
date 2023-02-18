import java.util.LinkedList;
import java.util.Queue;

public class First_negative {

    // Return every 1st negative integer that is present in every subarray of size k

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        int[] arr = { -8, 2, 3, -6, 10 };
        int k = 2;

        // int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
        // int k = 3;

        // int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28, -9 };
        // int k = 3;

        int start = 0;
        int end = 0;

        while (end < arr.length) {

            if (arr[end] < 0) {
                q.add(arr[end]);
            }

            if ((end - start + 1) < k) {
                end++;
            } else {
                if (!q.isEmpty()) {
                    System.out.print(q.peek() + " ");
                } else {
                    System.out.print("0 ");
                }
                if (arr[start] < 0) {
                    q.remove();
                }

                start++;
                end++;
            }
        }

    }
}