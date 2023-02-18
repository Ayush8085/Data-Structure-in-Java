public class Search_in_Nearly_Sorted_Array {

    // Return the index at which 'k' is present in the nearly sorted array.

    // the element which is suppose to be at ith position will be at ith, (i-1)th or
    // (i+1)th

    public static void main(String[] args) {

        int[] arr = { 5, 30, 20, 40 };
        // int[] arr = { 5, 10, 30, 20, 40 };
        int k = 10;

        try {

            int start = 0;
            int end = arr.length - 1;
            int mid = 0;

            boolean flag = false;
            while (start <= end) {
                mid = end - (end - start) / 2;

                if (mid == 0) {
                    if (arr[mid] == k) {
                        flag = true;
                        break;
                    } else if (arr[mid + 1] == k) {
                        mid += 1;
                        flag = true;
                        break;
                    }
                }
                if (arr[mid] == k) {
                    flag = true;
                    break;
                } else if (arr[mid + 1] == k) {
                    mid += 1;
                    flag = true;
                    break;
                } else if (arr[mid - 1] == k) {
                    mid -= 1;
                    flag = true;
                    break;
                } else if (arr[mid] > k) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (flag)
                System.out.println(mid);
        } catch (Exception e) {
            System.out.println("Not Found");
        }
    }
}
