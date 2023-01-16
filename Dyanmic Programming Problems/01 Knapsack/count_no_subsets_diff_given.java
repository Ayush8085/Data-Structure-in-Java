public class count_no_subsets_diff_given {

    // Given an array and difference, return the total no. of subsets that can be
    // made having difference equal to the given difference.

    public static void main(String[] args) {

        int[] arr = { 1, 2, 1, 3 };
        int diff = 1;

        int ans = countNoSubsetDiffGiven(arr, diff, arr.length);

        System.out.println(ans);

    }

    private static int countNoSubsetDiffGiven(int[] arr, int diff, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int s1 = (diff + sum) / 2; // Formula to calculate sum of subset 1

        // Now, perform "count subset sum" problem's algo
        int[][] table = new int[n + 1][s1 + 1];

        for (int i = 0; i <= s1; i++) {
            table[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s1; j++) {
                if (arr[i - 1] <= j) {
                    table[i][j] = table[i - 1][j] + table[i - 1][j - arr[i - 1]];
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[n][s1];
    }
}
