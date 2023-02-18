public class Next_Letter {

    // Return the letter after 'k' present in the sorted array.

    public static void main(String[] args) {

        char[] arr = { 'a', 'c', 'f', 'h' };
        char k = 'b';

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        char res = '#';
        while (start <= end) {
            mid = end - (end - start) / 2;

            if (arr[mid] == k) {
                if (mid != (arr.length - 1)) {
                    res = arr[mid + 1];
                }
                break;
            } else if (arr[mid] > k) {
                end = mid - 1;
                res = arr[mid];
            } else {
                start = mid + 1;
            }
        }

        if (res != '#')
            System.out.println(res);
        else
            System.out.println("'" + k + "'" + " doesn't have next letter!");
    }
}
