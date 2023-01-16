public class count_subset_sum {

    // Given an array and sum, return the total count of subsets that can be made
    // using the elements of the array

    public static void main(String[] args) {

        int[] arr = { 2, 3, 5, 6, 8, 10 };
        int sum = 10;

        int ans = countSubsetSum(arr, sum, arr.length);

        System.out.println(ans);
    }

    private static int countSubsetSum(int[] arr, int sum, int n) {

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
                    table[i][j] = table[i - 1][j] + table[i - 1][j - arr[i - 1]];
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[n][sum];
    }
}
