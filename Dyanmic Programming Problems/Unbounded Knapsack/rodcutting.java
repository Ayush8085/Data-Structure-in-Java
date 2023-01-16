public class rodcutting {
    // Unbounded knapsack

    // Given length of a rod and price of each pieces of the rod, return the maximum
    // profit that can be obtained from selling the rod by
    // cutting it into pieces

    public static void main(String[] args) {

        int[] lengths = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int totalRod = 8;

        int ans = rodCutting(lengths, price, totalRod);

        System.out.println(ans);

    }

    private static int rodCutting(int[] lengths, int[] price, int n) {

        int[][] table = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            table[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (lengths[i - 1] <= j) {
                    int include = price[i - 1] + table[i][j - lengths[i - 1]];
                    int exclude = table[i - 1][j];
                    table[i][j] = Math.max(include, exclude);
                } else {
                    int exclude = table[i - 1][j];
                    table[i][j] = exclude;
                }
            }
        }

        return table[n][n];
    }
}
