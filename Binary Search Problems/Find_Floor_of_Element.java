public class Find_Floor_of_Element {

    // Return the floor value of 'k' from the given sorted array.

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 8, 10, 10, 12, 19 };
        int k = 15;

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        int res = Integer.MAX_VALUE;
        while (start <= end) {
            mid = end - (end - start) / 2;

            // if(mid==0)
            if (arr[mid] > k) {
                end = mid - 1;
            } else if (arr[mid] <= k) {
                start = mid + 1;

                res = arr[mid];
            }
        }

        System.out.println(res);
    }
}
