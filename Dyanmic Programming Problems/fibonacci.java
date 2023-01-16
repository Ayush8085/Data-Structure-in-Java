import java.util.HashMap;
import java.util.Map;

// Time complexity will be O(n)
// Space complexity will be O(n)

public class fibonacci {
    public static void main(String[] args) {

        Map<Integer, Long> map = new HashMap<>();

        System.out.println(fib(6, map));
        System.out.println(fib(7, map));
        System.out.println(fib(8, map));
        System.out.println(fib(50, map));
        System.out.println(fib(70, map));

    }

    private static long fib(int n, Map<Integer, Long> map) {
        if (n <= 2) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long ans = fib(n - 1, map) + fib(n - 2, map);
        map.put(n, ans);

        return ans;
    }

}
