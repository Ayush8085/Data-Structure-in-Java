public class Longest_Common_Substring {

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "abce";

        int n = s1.length();
        int m = s2.length();

        int ans = longestCommonSubstring(s1, s2, n, m);

        System.out.println(ans);
    }

    private static int longestCommonSubstring(String s1, String s2, int n, int m) {

        int[][] table = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            table[0][i] = 0;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                    ans = Math.max(ans, table[i][j]);
                } else {
                    table[i][j] = 0;
                }
            }
        }
        
        return ans;
    }
}
