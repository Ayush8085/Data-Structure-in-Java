import java.util.PriorityQueue;

public class Connect_to_Minimize_Cost {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int minCost = 0;

        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;

            minCost += sum;

            pq.add(sum);
        }

        System.out.println(pq);
        System.out.println(minCost);
    }
}
