public class can_sum_tab {

    // Time complextiy is O(targetSum * arr.length).
    // Space complextiy is O(targetSum).

    public static void main(String[] args) {

        int[] arr = { 2, 3 };
        System.out.println(canSum(7, arr));

        int[] arr1 = { 5, 3, 4, 7 };
        System.out.println(canSum(7, arr1));

        int[] arr2 = { 2, 4 };
        System.out.println(canSum(7, arr2));

        int[] arr3 = { 2, 5, 3 };
        System.out.println(canSum(8, arr3));

        int[] arr4 = { 7, 14 };
        System.out.println(canSum(300, arr4));
    }

    private static boolean canSum(int targetSum, int[] arr) {

        boolean[] table = new boolean[targetSum + 1];

        for (int i = 0; i <= targetSum; i++) {
            table[i] = false;
        }
        table[0] = true;

        for (int i = 0; i < targetSum; i++) {
            if (table[i] == true) {
                for (int element : arr) {
                    if (i + element <= targetSum)
                        table[i + element] = true;
                }
            }
        }

        return table[targetSum];
    }
}
