public class Matrix_Chain_Multiplication {

    // Return the minimum cost to multiply the matrices, dimension of matrices are
    // given in the array

    // Matrix A = 40 * 20
    // Matrix B = 20 * 30
    // so on

    public static void main(String[] args) {

        int[] arr = { 40, 20, 30, 10, 30 };

        int ans = MCM(arr, 1, arr.length - 1);

        System.out.println(ans);

    }

    private static int MCM(int[] arr, int i, int j) {

        if (i >= j) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int tempAns = MCM(arr, i, k) + MCM(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            minCost = Math.min(tempAns, minCost);
        }

        return minCost;
    }

}