public class Shortest_Common_Supersequence {

    // Return the size of shortest common supersequence that can be formed
    // Supersequence --> A string in which both the strings are present.

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        // String s1 = "geek";
        // String s2 = "eke";

        int ans = ShortestCommonSuperstring(s1, s2, s1.length(), s2.length());

        System.out.println(ans);

    }

    private static int ShortestCommonSuperstring(String s1, String s2, int n, int m) {

        int[][] table = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            table[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        return (n + m) - table[n][m];
    }
}
