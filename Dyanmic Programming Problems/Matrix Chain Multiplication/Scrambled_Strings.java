import java.util.HashMap;
import java.util.Map;

public class Scrambled_Strings {

    // Return true/false, if s2 is scrambled string of s1

    // Scrambled --> 1. binary tree
    //               2. node must not be empty (" ");

    public static void main(String[] args) {

        Map<String, Boolean> map = new HashMap<>();
        String s1 = "great";
        String s2 = "ategr";

        // String s1 = "abcde";
        // String s2 = "caebd";

        if (s1.length() != s2.length()) {
            System.out.println("false");
        } else {
            System.out.println(scrambledString(s1, s2, map));
        }
    }

    private static boolean scrambledString(String s1, String s2, Map<String, Boolean> map) {

        String key = s1 + "," + s2;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        if (n <= 1) {
            return false;
        }

        for (int i = 1; i <= n - 1; i++) {

            if (scrambledString(s1.substring(0, i), s2.substring(n - i), map)
                    && scrambledString(s1.substring(i), s2.substring(0, i + 1), map)) {
                map.put(key, true);
                return true;
            }
            if (scrambledString(s1.substring(0, i), s2.substring(0, i), map)
                    && scrambledString(s1.substring(i), s2.substring(i), map)) {
                map.put(key, true);
                return true;
            }
        }

        map.put(key, false);
        return false;
    }
}