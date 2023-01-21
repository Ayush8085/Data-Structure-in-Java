import java.util.HashMap;
import java.util.Map;

public class Boolean_Paranthesis {

    // EVALUATE EXPRESSION TO TRUE

    // Return the no. of ways in which the string can be evaluated to get true

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        String s = "T|F&T^F";

        int ans = booleanParanthesis(s, map, 0, s.length() - 1, 1);

        System.out.println(ans);

    }

    private static int booleanParanthesis(String s, Map<String, Integer> map, int i, int j, int isTrue) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            if (isTrue == 1) {
                return (s.charAt(i) == 'T') ? 1 : 0;
            } else {
                return (s.charAt(i) == 'F') ? 1 : 0;
            }
        }

        String key = i+ "," +j+ "," +isTrue;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        int ans = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int leftTrue = booleanParanthesis(s, map, i, k - 1, 1);
            int leftFalse = booleanParanthesis(s, map, i, k - 1, 0);
            int rightTrue = booleanParanthesis(s, map, k + 1, j, 1);
            int rightFalse = booleanParanthesis(s, map, k + 1, j, 0);

            if (s.charAt(k) == '&') {
                if (isTrue == 1) {
                    ans += leftTrue * rightTrue;
                } else {
                    ans += (leftFalse * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightFalse);
                }
            } else if (s.charAt(k) == '|') {
                if (isTrue == 1) {
                    ans += (leftFalse * rightTrue) + (leftTrue * rightFalse) + (leftTrue * rightTrue);
                } else {
                    ans += leftFalse * rightFalse;
                }
            } else if (s.charAt(k) == '^') {
                if (isTrue == 1) {
                    ans += (leftFalse * rightTrue) + (leftTrue * rightFalse);
                } else {
                    ans += (leftFalse * rightFalse) + (leftTrue * rightTrue);
                }
            }

        }

        map.put(key, ans);

        return ans;
    }
}
