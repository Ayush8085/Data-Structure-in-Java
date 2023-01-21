public class Min_deletion_make_palindrome {

    // Return the minimum no. of deletions to be performed to make the given string palindrome
    
    public static void main(String[] args) {
        
        String s1 = "agbcba";

        int ans = MinDeletionMakePalindrome(s1, s1.length());

        System.out.println(ans);

    }

    private static int MinDeletionMakePalindrome(String s1, int n) {

        String s2 = "";
        for(int i=n-1; i>=0; i--) {
            s2 += s1.charAt(i);
        }
        
        int[][] table = new int[n+1][n+1];

        for(int i=0; i<=n; i++) {
            table[i][0] = 0;
        }
        for(int i=0; i<=n; i++) {
            table[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    table[i][j] = table[i-1][j-1] + 1;
                }
                else {
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                }
            }
        }

        return n - table[n][n];
    }
}
