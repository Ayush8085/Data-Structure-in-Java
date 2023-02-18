public class Find_in_Bitonic_Array {

    // Return the index of 'k' from the given Bitonic array.

    // Bitonic array --> increases than decreases, no element is repeated.

    public static void main(String[] args) {

        int[] arr = { 1, 3, 8, 12, 4, 2 };
        int k = 5;

        int peak = peakElement(arr, 0, arr.length - 1);

        int acc = binarySearchAccending(arr, 0, peak - 1, k);
        int dec = binarySearchDecending(arr, peak, arr.length - 1, k);

        if (acc != -1)
            System.out.println(acc);
        else if (dec != -1)
            System.out.println(dec);
        else
            System.out.println("Not Found");
    }

    private static int binarySearchAccending(int[] arr, int start, int end, int k) {
        int mid = 0;

        while (start <= end) {
            mid = end - (end - start) / 2;

            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int binarySearchDecending(int[] arr, int start, int end, int k) {
        int mid = 0;

        while (start <= end) {
            mid = end - (end - start) / 2;

            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int peakElement(int[] arr, int start, int end) {
        int mid = 0;

        while (start <= end) {
            mid = end - (end - start) / 2;

            if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                }
            } else if (mid == arr.length - 1) {
                if (arr[mid] > arr[arr.length - 2]) {
                    return mid;
                } else {
                    end--;
                }
            } else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
