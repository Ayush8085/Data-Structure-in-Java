public class First_1_in_Infinity_Binary_Sorted_Array {

    // Return the index of first '1' in the given infinity binary sorted array.

    public static void main(String[] args) {

        int[] arr = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 };

        int start = 0;
        int end = 1;
        int mid = 0;

        // --------USING 'POSITION IN INFINITY' APPROACH----------
        while (arr[end] != 1) {
            start = end;
            end *= 2;
        }

        // --------USING 'FIRST OCCURANCE' APPROACH----------
        int firstOccurance = -1;
        while (start <= end) {
            mid = end - (end - start) / 2;

            if (arr[mid] == 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
                firstOccurance = mid;
            }
        }

        System.out.println(firstOccurance);

    }
}
