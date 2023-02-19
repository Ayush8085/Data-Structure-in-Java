public class Allocate_Min_no_of_Pages {

    // Return the minimum maximum number of pages to be allocated from the given
    // array of book to 'k' students.

    // Constraints :- 1. distribute among 'k' students.
    // 2. Atleast 1 book must be allocated to each student.
    // 3. Books must be distributed continuously.

    public static void main(String[] args) {

        int[] arr = { 10, 20, 30, 40 };
        int k = 2;

        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            end += arr[i];
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
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > limit) {
                student++;
                sum = arr[i];
                if (student > k) {
                    return false;
                }
            }
        }

        return true;
    }
}
