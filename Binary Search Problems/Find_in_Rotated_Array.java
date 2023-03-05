public class Find_in_Rotated_Array {

    // Return the index of 'k' in given sorted rotated array.

    public static void main(String[] args) {

        // int[] arr = { 11, 12, 15, 18, 2, 5, 6, 8 };
        // int[] arr = { 2, 5, 6, 8, 11, 12, 15, 18 };
        // int[] arr = { 2, 5, 6, 8, 11, 12, 15 };
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        // int[] arr = { 4, 5, 6, 7, 0 };
        int k = 0;
        int n = arr.length;

        int start = 0;
        int end = n - 1;
        int mid = 0;

        boolean found = false;
        while (start <= end) {
            mid = end - (end - start) / 2;

            if (arr[mid] == k) {
                found = true;
                break;
            }
            // check if left is sorted
            if (arr[mid] > arr[start]) {
                if (k <= arr[mid] && k >= arr[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // check if right is sorted
            else {
                if (k >= arr[mid] && k <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        if (found) {
            System.out.println(mid);
        } else {
            System.out.println("Not Found");
        }

    }
}
