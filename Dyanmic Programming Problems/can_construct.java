import java.util.HashMap;
import java.util.Map;

// Return true if the target string can be created from the set of given arrays

// Time complexity is O(n*m^2)
// Space complexity is O(m^2)

public class can_construct {

    public static void main(String[] args) {

        Map<String, Boolean> map = new HashMap<>();
        String[] arr = { "ab", "abc", "cd", "def", "abcd" };
        System.out.println(canConstruct("abcdef", arr, map));

        Map<String, Boolean> map1 = new HashMap<>();
        String[] arr1 = { "bo", "rd", "ate", "t", "ska", "sk", "boar" };
        System.out.println(canConstruct("skateboard", arr1, map1));

        Map<String, Boolean> map2 = new HashMap<>();
        String[] arr2 = { "a", "p", "ent", "enter", "ot", "o", "t" };
        System.out.println(canConstruct("enterapotentpot", arr2, map2));

        Map<String, Boolean> map3 = new HashMap<>();
        String[] arr3 = { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" };
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3, map3));

    }

    private static boolean canConstruct(String target, String[] arr, Map<String, Boolean> map) {

        if (target == "")
            return true;
        if (map.containsKey(target))
            return map.get(target);

        for (String element : arr) {
            if (target.indexOf(element) == 0) {
                String suffix = target.substring(element.length());
                if (canConstruct(suffix, arr, map) == true) {
                    map.put(target, true);
                    return true;
                }
            }
        }

        map.put(target, false);
        return false;
    }
}
