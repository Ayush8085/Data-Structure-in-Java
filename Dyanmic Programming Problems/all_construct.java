import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// I WAS ENABLE TO SOLVE THIS PROBLEM

public class all_construct {

    public static void main(String[] args) {

        // Map<String, Integer> map = new HashMap<>();
        String[] arr = { "ab", "abc", "cd", "def", "abcd" };
        // System.out.println(countConstruct("abcdef", arr, map));
        System.out.println(allConstruct("abcdef", arr));

        // Map<String, Integer> map1 = new HashMap<>();
        String[] arr1 = { "bo", "rd", "ate", "t", "ska", "sk", "boar" };
        // System.out.println(countConstruct("skateboard", arr1, map1));
        System.out.println(allConstruct("skateboard", arr1));

        // Map<String, Integer> map2 = new HashMap<>();
        String[] arr2 = { "a", "p", "ent", "enter", "ot", "o", "t" };
        // System.out.println(countConstruct("enterapotentpot", arr2, map2));
        System.out.println(allConstruct("enterapotentpot", arr2));

        // Map<String, Integer> map3 = new HashMap<>();
        String[] arr3 = { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" };
        // System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3,
        // map3));
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3));

        // Map<String, Integer> map4 = new HashMap<>();
        String[] arr4 = { "purp", "p", "ur", "le", "purpl" };
        // System.out.println(countConstruct("purple", arr4, map4));
        System.out.println(allConstruct("purple", arr4));
    }

    private static ArrayList<ArrayList<String>> allConstruct(String target, String[] arr) {

        if (target == "")
            return new ArrayList<ArrayList<String>>();

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String element : arr) {
            if (target.indexOf(element) == 0) {
                String suffix = target.substring(element.length());
                ArrayList<ArrayList<String>> suffixWays = allConstruct(suffix, arr);
                for (ArrayList<String> row : suffixWays) {
                    row.add(0, element);
                }

            }
        }

        return result;
    }
}
