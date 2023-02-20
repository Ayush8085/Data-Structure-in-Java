public class Allocate_Min_no_of_Pages {

    // Return the minimum maximum number of pages to be allocated from the given
    // array of book to 'k' students.

    // NOTE :- THE ARRAY CAN BE UNSORTED ALSO.

    // Constraints :- 1. distribute among 'k' students.
    // 2. Atleast 1 book must be allocated to each student.
    // 3. Books must be distributed continuously.

    public static void main(String[] args) {

        // int[] arr = { 10, 20, 30, 40 }; // 60
        int[] arr = { 20, 10, 40, 30 }; // 70
        int k = 2;

        int start = 0;
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }

        start = max;

        int end = 0;
        for (int i : arr) {
            end += i;
        }

        int mid = 0;

        int res = -1;
        while (start <= end) {
            mid = end - (end - start) / 2;

            if (isValid(arr, arr.length, k, mid)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        System.out.println(res);
    }

    private static boolean isValid(int[] arr, int n, int k, int limit) {

        int student = 1;

        int sum = 0;

        for (int i : arr) {
            sum += i;
            if (sum > limit) {
                student++;
                sum = i;
                if (student > k) {
                    return false;
                }
            }
        }

        return true;
    }
}
