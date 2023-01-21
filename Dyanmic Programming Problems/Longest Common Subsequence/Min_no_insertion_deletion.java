public class Min_no_insertion_deletion {

    // Return the minimum no. of insertion & deletion that has to be made to convert
    // s1 to s2

    public static void main(String[] args) {

        String s1 = "heap";
        String s2 = "pea";

        // String s1 = "loveitman";
        // String s2 = "manlove";

        int ans = MinNoInsertionDeletion(s1, s2, s1.length(), s2.length());

        System.out.println(ans);

    }

    private static int MinNoInsertionDeletion(String s1, String s2, int n, int m) {

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

        int deletion = n - table[n][m];

        int insertion = m - table[n][m];

        return insertion + deletion;

    }
}
