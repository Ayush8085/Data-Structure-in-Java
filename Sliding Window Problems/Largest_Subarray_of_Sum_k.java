public class Largest_Subarray_of_Sum_k {

    // Return the largest subarray of sum k.

    public static void main(String[] args) {

        int[] arr = { 4, 1, 1, 1, 2, 3, 5 };
        int k = 4;

        int start = 0;
        int end = 0;

        int sum = 0;
        int max = 0;
        while (end < arr.length) {

            sum += arr[end];

            if (sum < k) {
                end++;
            } else if (sum > k) {
                while (sum > k) {
                    sum -= arr[start];
                    start++;
                }
                if (sum == k) {
                    max = Math.max((end - start + 1), max);
                }
                end++;
            } else {
                max = Math.max((end - start + 1), max);

                end++;
            }
        }

        System.out.println(max);
    }
}
