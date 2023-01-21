public class Print_Shortest_Common_Supersequence {

    // Print the shortest common supersequence of the 2 given strings.

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        String ans = PrintShortestCommonSupersequence(s1, s2, s1.length(), s2.length());

        System.out.println(ans);

    }

    private static String PrintShortestCommonSupersequence(String s1, String s2, int n, int m) {

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

        String rev_ans = "";
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                rev_ans += s1.charAt(i - 1);
                i--;
                j--;
            } else {
                if (table[i][j - 1] > table[i - 1][j]) {
                    rev_ans += s2.charAt(j - 1);
                    j--;
                } else {
                    rev_ans += s1.charAt(i - 1);
                    i--;
                }
            }
        }
        while (i > 0) {
            rev_ans += s1.charAt(i - 1);
            i--;
        }
        while (j > 0) {
            rev_ans += s2.charAt(j - 1);
            j--;
        }

        String ans = "";
        for (int k = rev_ans.length() - 1; k >= 0; k--) {
            ans += rev_ans.charAt(k);
        }

        return ans;

    }
}
