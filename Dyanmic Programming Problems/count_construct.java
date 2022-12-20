import java.util.HashMap;
import java.util.Map;

public class count_construct {

    // Return the total number of ways in which the target string can be
    // constructed.

    // Time complexity is O(n*m^2)
    // Space complexity is O(m^2)

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        String[] arr = { "ab", "abc", "cd", "def", "abcd" };
        System.out.println(countConstruct("abcdef", arr, map));

        Map<String, Integer> map1 = new HashMap<>();
        String[] arr1 = { "bo", "rd", "ate", "t", "ska", "sk", "boar" };
        System.out.println(countConstruct("skateboard", arr1, map1));

        Map<String, Integer> map2 = new HashMap<>();
        String[] arr2 = { "a", "p", "ent", "enter", "ot", "o", "t" };
        System.out.println(countConstruct("enterapotentpot", arr2, map2));

        Map<String, Integer> map3 = new HashMap<>();
        String[] arr3 = { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" };
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3, map3));

        Map<String, Integer> map4 = new HashMap<>();
        String[] arr4 = { "purp", "p", "ur", "le", "purpl" };
        System.out.println(countConstruct("purple", arr4, map4));
    }

    private static int countConstruct(String target, String[] arr, Map<String, Integer> map) {

        if (target == "")
            return 1;
        if (map.containsKey(target))
            return map.get(target);

        int totalWays = 0;

        for (String element : arr) {
            if (target.indexOf(element) == 0) {
                String suffix = target.substring(element.length());
                int numWaysForRest = countConstruct(suffix, arr, map);
                totalWays += numWaysForRest;
            }
        }

        map.put(target, totalWays);
        return totalWays;
    }

}
