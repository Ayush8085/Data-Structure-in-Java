import java.util.HashMap;
import java.util.Map;

public class Pick_Toys {

    // Question as a story :-
    // John is at a toy store help him pick maximum number of toys. He can only
    // select in a continuous manner and he can select only two types of toys.

    // Return the size of the longest substring with maximum count of 2 unique characters.

    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        String s = "abaccab";

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

            if (map.size() < 2) {
                end++;
            } else if (map.size() > 2) {
                while (map.size() > 2) {
                    int count = map.get(s.charAt(start)) - 1;
                    if (count == 0) {
                        map.remove(s.charAt(start));
                    } else {
                        map.put(s.charAt(start), count);
                    }
                    start++;
                }
                if (map.size() == 2) {
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
