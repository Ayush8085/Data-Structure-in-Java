public class Max_in_Bitonic_Array {

    // Return the maximum element from the given Bitonic array.

    // Bitonic array --> increases than decreases, no element is repeated.

    public static void main(String[] args) {

        // int[] arr = { 1, 3, 8, 12, 4, 2 };
        int[] arr = { 1, 3, 8, 12, 24, 32 };

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = end - (end - start) / 2;

            if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    break;
                }
            } else if (mid == arr.length - 1) {
                if (arr[mid] > arr[arr.length - 2]) {
                    break;
                } else {
                    end--;
                }
            } else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                break;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(arr[mid]);
    }
}
