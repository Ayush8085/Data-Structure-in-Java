public class equal_sum_partition {

    // Given an array, return true or false if it can be divided into two parts
    // having equal sum.

    public static void main(String[] args) {

        int[] arr = { 1, 5, 11, 5 };
        // int[] arr = {1,5,11,5,3};

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        boolean ans = equalSumPartition(arr, sum, arr.length);

        System.out.println(ans);

    }

    private static boolean equalSumPartition(int[] arr, int sum, int n) {

        if (sum % 2 != 0) {
            return false;
        }

        return subsetsum(arr, sum / 2, n);
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
                    table[i][j] = table[i - 1][j] || table[i - 1][j - arr[i - 1]];
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[n][sum];
    }
}
