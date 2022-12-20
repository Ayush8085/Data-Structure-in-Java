import java.util.Arrays;

public class count_construct_tab {

    public static void main(String[] args) {

        String[] arr = { "ab", "abc", "cd", "def", "abcd" };
        System.out.println(countConstruct("abcdef", arr));

        String[] arr1 = { "bo", "rd", "ate", "t", "ska", "sk", "boar" };
        System.out.println(countConstruct("skateboard", arr1));

        String[] arr2 = { "a", "p", "ent", "enter", "ot", "o", "t" };
        System.out.println(countConstruct("enterapotentpot", arr2));

        String[] arr3 = { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" };
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3));

        String[] arr4 = { "purp", "p", "ur", "le", "purpl" };
        System.out.println(countConstruct("purple", arr4));
    }

    private static int countConstruct(String target, String[] arr) {
        int[] table = new int[target.length() + 1];
        Arrays.fill(table, 0);

        table[0] = 1;

        for (int i = 0; i <= target.length(); i++) {
            if (table[i] != 0) {
                for (String element : arr) {
                    if (i + element.length() <= target.length()) {
                        if (target.substring(i, i + element.length()).equals(element)) {
                            table[i + element.length()] += table[i];
                        }
                    }
                }
            }
        }

        return table[target.length()];
    }
}
