import java.util.HashMap;
import java.util.Map;

public class Min_Partition_Make_Palindrome {

    // Return the minimum no. of partitions required so that all the parts are
    // palindrome.
    // Example - "ntitin" --> "n | tit | i | n" --> 3 partitions

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        // String s = "nitin";
        String s = "nitik";

        int ans = MinNoPartitionMakePalindrome(s, map, 0, s.length() - 1);

        System.out.println(ans);

    }

    private static int MinNoPartitionMakePalindrome(String s, Map<String, Integer> map, int i, int j) {

        if (i >= j) {
            return 0;
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }

        String key = i + "," + j;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int minPartition = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int tempAns = MinNoPartitionMakePalindrome(s, map, i, k) + MinNoPartitionMakePalindrome(s, map, k + 1, j)
                    + 1;
            minPartition = Math.min(minPartition, tempAns);
            map.put(key, minPartition);
        }

        return minPartition;
    }

    private static boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}