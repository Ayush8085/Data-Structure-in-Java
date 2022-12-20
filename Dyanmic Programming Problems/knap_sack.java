import java.util.HashMap;
import java.util.Map;

public class knap_sack {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] val = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println(knapsack(val, wt, W, val.length, map));
    }

    private static int knapsack(int[] val, int[] wt, int W, int n, Map<Integer, Integer> map) {
        if (W == 0 || n == 0)
            return 0;

        if (map.containsKey(n))
            return map.get(n);

        if (wt[n - 1] <= W) {
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1, map);
            // exclude
            int ans2 = knapsack(val, wt, W, n - 1, map);

            map.put(n, Math.max(ans1, ans2));
            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, W, n - 1, map);
        }
    }
}
