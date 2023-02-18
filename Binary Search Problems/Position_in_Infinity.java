public class Position_in_Infinity {

    // Return the index of 'k' in the given infinity sorted array.

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }; // this array can be infinity i.e., the size
                                                                           // is unknown
        int k = 7;

        int start = 0;
        int end = 1;
        int mid = 0;

        while (arr[end] < k) {
            start = end;
            end *= 2;
        }

        while (start <= end) {
            mid = end - (end - start) / 2;

            // if (arr[end] < k) {
            // start = end;
            // end *= 2;
            // }

            if (arr[mid] == k) {
                break;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(mid);
    }
}
