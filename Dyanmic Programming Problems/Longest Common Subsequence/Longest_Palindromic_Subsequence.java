public class Longest_Palindromic_Subsequence {

    // Return length of longest palindromic subsequence that can be obtained from
    // the given string.

    public static void main(String[] args) {

        String s1 = "agbcba";

        int ans = longestPalindromicSubsequence(s1, s1.length());

        System.out.println(ans);

    }

    private static int longestPalindromicSubsequence(String s1, int n) {

        String s2 = "";
        for (int i = n - 1; i >= 0; i--) {
            s2 += s1.charAt(i);
        }
        // int m = s2.length();

        int[][] table = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            table[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        return table[n][n];
    }
}
