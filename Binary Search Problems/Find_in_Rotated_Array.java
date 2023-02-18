public class Find_in_Rotated_Array {

    // Return the index of 'k' in given sorted rotated array.

    public static void main(String[] args) {

        // int[] arr = { 11, 12, 15, 18, 2, 5, 6, 8 };
        // int[] arr = { 2, 5, 6, 8, 11, 12, 15, 18 };
        int[] arr = { 2, 5, 6, 8, 11, 12, 15 };
        int k = 15;

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = end - (end - start) / 2;

            if (mid == 0)
                break;
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                break;
            } else if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (mid == 0) {
            System.out.println(binarySearch(arr, 0, arr.length-1, k));
        } else {

            if (binarySearch(arr, 0, mid - 1, k) > 0)
                System.out.println(binarySearch(arr, 0, mid - 1, k));
            else if (binarySearch(arr, mid + 1, arr.length - 1, k) > 0)
                System.out.println(binarySearch(arr, mid + 1, arr.length - 1, k));
        }

    }

    private static int binarySearch(int[] arr, int start, int end, int k) {

        int mid = 0;

        while (start <= end) {
            mid = end - (end - start) / 2;

            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
