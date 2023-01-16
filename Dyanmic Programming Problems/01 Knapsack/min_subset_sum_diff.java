import java.util.ArrayList;

public class min_subset_sum_diff {

    // Given an array, make two subsets such that there difference is minimum.
    
    public static void main(String[] args) {
        
        int[] arr = {1,6,11,5};

        int range = 0;
        for(int i=0; i<arr.length; i++) {
            range += arr[i];
        }

        int ans = minSubsetSumDiff(arr, range, arr.length);

        System.out.println(ans);

    }

    private static int minSubsetSumDiff(int[] arr, int range, int n) {
        
        boolean[][] table = new boolean[n+1][range+1];

        for(int i=0; i<=range; i++) {
            table[0][i] = false;
        }
        for(int i=0; i<=n; i++) {
            table[i][0] = true;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=range; j++) {
                if(arr[i-1] <= j) {
                    table[i][j] = table[i-1][j] || table[i-1][j-arr[i-1]];
                }
                else {
                    table[i][j] = table[i-1][j];
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<=range/2; i++) {
            if(table[n][i]) {
                list.add(i);
            }
        }

        int min_diff = Integer.MAX_VALUE;
        for(int i=0; i<list.size(); i++) {
            min_diff = Math.min(range-2*list.get(i), min_diff);
        }

        return min_diff;
    }
}
