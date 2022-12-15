import java.util.HashMap;
import java.util.Map;

// QUESTION
// A person is at the top-left of the m*n grid and has to get to the bottm-right corner of the grid.
// He can only move right and down.
// In how many ways can he reach the destination.

// Time complexity is O(m*n)
// Space complexity is O(m+n)

class grid_traveler {
    public static void main(String[] args) {

        Map<String, Long> map = new HashMap<>();

        System.out.println(gridTraveler(1, 1, map));
        System.out.println(gridTraveler(2, 3, map));
        System.out.println(gridTraveler(3, 2, map));
        System.out.println(gridTraveler(3, 3, map));
        System.out.println(gridTraveler(18, 18, map));
    }

    private static long gridTraveler(int n, int m, Map<String, Long> map) {

        if (n == 1 && m == 1) {
            return 1;
        }
        if (n == 0 || m == 0) {
            return 0;
        }
        String key = n + "," + m;

        if(map.containsKey(key)) {
            return map.get(key);
        }
        long ans = gridTraveler(n - 1, m, map) + gridTraveler(n, m - 1, map);
        map.put(key, ans);

        return ans;
    }
}