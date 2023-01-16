public class subset_sum {

    // Given an array and sum, state true or false if the sum can be acchived by
    // taking subset from array.

    public static void main(String[] args) {

        int[] arr = { 2, 3, 7, 8, 10 };
        // int[] arr = { 2, 3, 7, 10 };
        int sum = 11;

        System.out.println(subsetsum(arr, sum, arr.length));
    }

    private static boolean subsetsum(int[] arr, int sum, int n) {

        boolean[][] table = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            table[0][i] = false;
        }
        for (int i = 0; i <= n; i++) {
            table[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    table[i][j] = table[i - 1][j - arr[i - 1]] || table[i - 1][j];
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[n][sum];
    }
}
