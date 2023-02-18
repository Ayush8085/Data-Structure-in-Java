public class Number_of_Times_Rotated {

    // Find out how many times the sorted array is rotated.

    public static void main(String[] args) {

        // int[] arr = { 11, 12, 15, 18, 2, 5, 6, 8 };
        // int[] arr = { 2, 5, 6, 8, 11, 12, 15, 18 };
        int[] arr = { 18, 2, 5, 6, 8, 11, 12, 15 };

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = end - (end - start) / 2;

            if (mid == 0)
                break;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                break;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(mid);
    }
}
