public class coin_change_I_Max {

    // Unbounded knapsack

    // Given an array and sum, return the total no. of ways in which elements add up
    // to given sum

    // Same as subset sum problem

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };
        int sum = 5;

        int ans = coinChangeMax(arr, sum, arr.length);

        System.out.println(ans);

    }

    private static int coinChangeMax(int[] arr, int sum, int n) {

        int[][] table = new int[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            table[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    table[i][j] = table[i - 1][j] + table[i][j - arr[i - 1]];
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[n][sum];
    }
}
