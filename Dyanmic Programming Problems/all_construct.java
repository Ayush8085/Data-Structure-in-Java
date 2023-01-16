import java.util.ArrayList;

// I WAS ENABLE TO SOLVE THIS PROBLEM

public class all_construct {

    public static void main(String[] args) {

        String[] arr = { "ab", "abc", "cd", "def", "abcd" };
        System.out.println(allConstruct("abcdef", arr));
        // ArrayList<ArrayList<String>> list = allConstruct("abcdef", arr);

        // String[] arr1 = { "bo", "rd", "ate", "t", "ska", "sk", "boar" };
        // System.out.println(allConstruct("skateboard", arr1));

        // String[] arr2 = { "a", "p", "ent", "enter", "ot", "o", "t" };
        // System.out.println(allConstruct("enterapotentpot", arr2));

        // String[] arr3 = { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" };
        // System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3));

        // String[] arr4 = { "purp", "p", "ur", "le", "purpl" };
        // System.out.println(allConstruct("purple", arr4));
    }

    private static ArrayList<ArrayList<String>> allConstruct(String target, String[] arr) {

        if (target == "")
            return new ArrayList<ArrayList<String>>();

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String element : arr) {
            if (target.indexOf(element) == 0) {
                String suffix = target.substring(element.length());
                ArrayList<ArrayList<String>> suffixWays = allConstruct(suffix, arr);
                // for (int i = 0; i < suffixWays.size(); i++) {
                //     // System.out.println("Hey");
                //     suffixWays.get(i).set(i, element);
                //     result.add(suffixWays.get(i));
                // }
                int i = 0;
                for(ArrayList<String> row: suffixWays) {
                    System.out.println("Hey");
                    // row.set(i, element);
                    row.add(element);
                    // i++;
                    result.add(row);
                }
            }
        }

        return result;
    }
}
