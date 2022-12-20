public class knap_sack_tab {
    
    public static void main(String[] args) {
        
        int[] val = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println(knapsack(val, wt, W, val.length));
    }

    private static int knapsack(int[] val, int[] wt, int W, int n) {

        int[][] table = new int[n+1][W+1];

        for(int i=0; i<=n; i++) {
            table[i][0] = 0;
        }

        for(int i=0; i<=W; i++) {
            table[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=W; j++) {
                int v = val[i-1];
                int w = wt[i-1];

                if(w <= j) {
                    int include = v + table[i-1][j-w];
                    int exclude = table[i-1][j];
                    table[i][j] = Math.max(include, exclude);
                }
                else {
                    int exclude = table[i-1][j];
                    table[i][j] = exclude;
                }
            }
        }


        return table[n][W];
    }
}
