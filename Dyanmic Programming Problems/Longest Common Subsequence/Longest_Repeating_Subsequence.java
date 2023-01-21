public class Longest_Repeating_Subsequence {

    // Return the length of the longest repeating subsequence present in the given
    // string

    public static void main(String[] args) {

        String s = "AABEBCDD";

        int ans = longestRepeatingSubsequence(s, s.length());

        System.out.println(ans);

    }

    private static int longestRepeatingSubsequence(String s, int n) {

        int[][] table = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
            table[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        return table[n][n];
    }
}
