public class Sequence_Pattern_Matching {

    // Return true if s1 is a subsequence of s2,
    // otherwise false

    public static void main(String[] args) {

        String s1 = "AXY";
        String s2 = "ADXCPY";

        boolean ans = sequencePatternMatching(s1, s2, s1.length(), s2.length());

        System.out.println(ans);

    }

    private static boolean sequencePatternMatching(String s1, String s2, int n, int m) {

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

        return n == table[n][m];
    }
}
