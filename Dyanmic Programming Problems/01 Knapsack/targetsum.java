public class targetsum {

    // Given an array and sum, return the no. of ways in which each element of the
    // array is assigned + or - and sum of the array after that is equal to given
    // sum.

    // This question is exactly as count no. subsets diff given problem.

    public static void main(String[] args) {

        int[] arr = { 1, 2, 1, 3 };
        int sum = 1;

        int ans = targetSum(arr, sum, arr.length);

        System.out.println(ans);

    }

    private static int targetSum(int[] arr, int sum, int n) {
        int sumOfarr = 0;
        for(int i=0; i<n; i++) {
            sumOfarr += arr[i];
        }

        int s = (sum + sumOfarr)/2;
        int[][] table = new int[n+1][s+1];

        for(int i=0; i<=s; i++) {
            table[0][i] = 0;
        }
        for(int i=0; i<=n; i++) {
            table[i][0] = 1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=s; j++) {
                if(arr[i-1] <= j) {
                    table[i][j] = table[i-1][j] + table[i-1][j-arr[i-1]];
                }
                else {
                    table[i][j] = table[i-1][j];
                }
            }
        }

        return table[n][s];
    }
}
