public class coin_change_II_Min {

    // Unbounded knapsack
    // COMPLEX PROBLEM

    // Given an array and sum, return the minimum no. of coins that can be used to
    // get sum equal to the given sum

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, };
        int sum = 5;

        int ans = coinChangeMin(arr, sum, arr.length);

        System.out.println(ans);

    }

    private static int coinChangeMin(int[] arr, int sum, int n) {

        int[][] table = new int[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            table[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
        }
        for (int i = 1; i <= sum; i++) {
            if (i % arr[1] == 0) {
                table[1][i] = 1;
            } else {
                table[1][i] = Integer.MAX_VALUE - 1;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    int include = table[i][j - arr[i - 1]] + 1;
                    int exclude = table[i - 1][j];

                    table[i][j] = Math.min(include, exclude);
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[n][sum];
    }
}
