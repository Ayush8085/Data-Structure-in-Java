import java.util.HashMap;
import java.util.Map;

public class Longest_substring_all_Unique_characters {

    // Return the size of the longest substring with all the unique characters in
    // it.

    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        String s = "pwwkew";

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

            if (map.size() < (end - start + 1)) {
                while (map.size() < (end - start + 1)) {
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
                if (map.size() == (end - start + 1)) {
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
