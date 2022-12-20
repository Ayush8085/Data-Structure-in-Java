import java.util.Arrays;

public class can_construct_tab {

    public static void main(String[] args) {

        String[] arr = { "ab", "abc", "cd", "def", "abcd" };
        System.out.println(canConstruct("abcdef", arr));

        String[] arr1 = { "bo", "rd", "ate", "t", "ska", "sk", "boar" };
        System.out.println(canConstruct("skateboard", arr1));

        String[] arr2 = { "a", "p", "ent", "enter", "ot", "o", "t" };
        System.out.println(canConstruct("enterapotentpot", arr2));

        String[] arr3 = { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" };
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3));
    }

    private static boolean canConstruct(String target, String[] arr) {

        boolean[] table = new boolean[target.length() + 1];
        Arrays.fill(table, false);

        table[0] = true;

        for (int i = 0; i <= target.length(); i++) {
            if (table[i] == true) {
                for (String element : arr) {
                    if (i + element.length() <= target.length()) {
                        if (target.substring(i, i + element.length()).equals(element)) {
                            table[i + element.length()] = true;
                        }
                    }
                }
            }
        }

        return table[target.length()];
    }
}
