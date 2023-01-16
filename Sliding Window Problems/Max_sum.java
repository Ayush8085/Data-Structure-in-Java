public class Max_sum {
    public static void main(String[] args) {

        int[] arr = { 2, 5, 1, 8, 2, 9, 1 };
        int k = 3;

        int start = 0;
        int end = 0;
        int sum = 0;

        int max = 0;

        while(end < arr.length) {

            sum = sum + arr[end];

            if((end-start+1) < k) {
                end++;
            }
            else if((end-start+1) == k) {
                max = (int)Math.max(sum, max);
                System.out.print(max+ " ");

                sum = sum - arr[start];
                start++;
                end++;
            }
        }
        System.out.print("\nThe maximum sum among all the sliding windows : " +max);
    }
}