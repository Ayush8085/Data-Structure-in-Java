public class First_and_Last_Occurance {

    // Return the first and last occurance of 'k' in the given sorted array.

    public static void main(String[] args) {

        int[] arr = { 2, 4, 10, 10, 10, 18, 20 };
        int k = 10;

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        int firstOccurance = -1;
        while (start <= end) {
            mid = end - (end - start) / 2;

            if (arr[mid] > k) {
                end = mid - 1;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                firstOccurance = mid;
                end = mid - 1;
            }
        }

        start = 0;
        end = arr.length - 1;

        int lastOccurance = -1;
        while (start <= end) {
            mid = end - (end - start) / 2;

            if (arr[mid] > k) {
                end = mid - 1;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                lastOccurance = mid;
                start = mid + 1;
            }
        }

        System.out
                .println("First Occurance at index: " + firstOccurance + "\nLast Occurance at index: " + lastOccurance);
    }
}