public class LCS {

    // Given 2 strings, return the maximum size of longest common subsequence that
    // can be possible
    public static void main(String[] args) {
        
        // String s1 = "abcde";
        // String s2 = "ace";

        String s1 = "abcdge";
        String s2 = "abedg";

        int n = s1.length();
        int m = s2.length();

        int ans = longestCommonSubsequence(s1, s2, n, m);

        System.out.println(ans);

    }

    private static int longestCommonSubsequence(String s1, String s2, int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }

        int ans = 0;
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            ans = longestCommonSubsequence(s1, s2, n - 1, m - 1) + 1;
        } else {
            int ans1 = longestCommonSubsequence(s1, s2, n - 1, m);
            int ans2 = longestCommonSubsequence(s1, s2, n, m - 1);

            ans = Math.max(ans1, ans2);
        }

        return ans;
    }
}