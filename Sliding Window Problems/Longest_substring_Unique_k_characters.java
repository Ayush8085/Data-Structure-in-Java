import java.util.HashMap;
import java.util.Map;

public class Longest_substring_Unique_k_characters {

    // Return the size of the longest substring with the given 'k' unique
    // characters.

    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        String s = "aabacbebebe";
        int k = 3;

        // String s = "aaaa";
        // int k = 2;

        int start = 0;
        int end = 0;

        int max = 0;
        while (end < s.length()) {

            if (map.containsKey(s.charAt(end))) {
                int count = map.get(s.charAt(end)) + 1;
                map.put(s.charAt(end), count);
            } else {
                map.put(s.charAt(end), 1);
            }

            if (map.size() < k) {
                end++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    // if (map.containsKey(s.charAt(start))) {
                    int count = map.get(s.charAt(start)) - 1;
                    if (count == 0) {
                        map.remove(s.charAt(start));
                    } else {
                        map.put(s.charAt(start), count);
                    }
                    // }
                    start++;
                }
                if (map.size() == k) {
                    max = Math.max((end - start + 1), max);
                }

                end++;
            } else {
                max = Math.max((end - start + 1), max);

                end++;
            }
        }

        System.out.println(max);
    }
}
