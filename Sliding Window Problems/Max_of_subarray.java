public class Max_of_subarray {

    // Return the maximum sum possible from all the subarrays of size k.

    public static void main(String[] args) {

        int[] arr = { 2, 5, 1, 8, 2, 9, 1 };
        // int[] arr = { -3, 1, -8, 4, -1, 2, 1, -5, 5 };
        int k = 3;

        int start = 0;
        int end = 0;

        int sum = 0;
        int max = Integer.MIN_VALUE;
        while(end < arr.length) {

            sum += arr[end];

            if((end-start+1) < k) {
                end++;
            }
            else {
                // System.out.print(sum+ " ");
                max = Math.max(sum, max);

                sum = sum - arr[start];

                start++;
                end++;
            }
        }

        System.out.println("\n" +max);
        
    }
}