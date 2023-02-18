public class Find_Ceil_of_Element {

    // Return the ceil value of 'k' from the given sorted array.

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 8, 10, 10, 12, 19 };
        int k = 0;

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        int res = Integer.MIN_VALUE;

        // while (start <= end) {
        // mid = end - (end - start) / 2;

        // if (arr[mid] == k) {
        // res = arr[mid];
        // break;
        // } else if (arr[mid] <= k) {
        // start = mid + 1;

        // res = arr[mid + 1];
        // } else if (arr[mid] > k) {
        // end = mid - 1;
        // }
        // }

        // if (res < 0)
        // System.out.println(arr[0]);
        // else
        // System.out.println(res);

        // -------------------ANOTHER WAY--------------------
        while (start <= end) {
            mid = end - (end - start) / 2;

            if (arr[mid] == k) {
                res = arr[mid];
                break;
            } else if (arr[mid] <= k) {
                start = mid + 1;

            } else if (arr[mid] > k) {
                end = mid - 1;
                res = arr[mid];
            }
        }

        System.out.println(res);
    }
}
