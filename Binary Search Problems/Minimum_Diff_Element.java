public class Minimum_Diff_Element {

    // Return the element which is closest to 'k' in the given sorted array.

    public static void main(String[] args) {

        // int[] arr = { 4, 6, 10 };
        // int k = 7;

        int[] arr = { 1, 3, 8, 12, 15 };
        int k = 13;

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        // ---------------FLOOR AND CEIL APPROACH-----------------
        // int floor = -1;
        // int ceil = -1;
        // while (start <= end) {
        //     mid = end - (end - start) / 2;

        //     if (arr[mid] == k) {
        //         floor = arr[mid];
        //         ceil = arr[mid];
        //         break;
        //     } else if (arr[mid] < k) {
        //         start = mid + 1;
        //         floor = arr[mid];
        //     } else {
        //         end = mid - 1;
        //         ceil = arr[mid];
        //     }
        // }

        // // System.out.println("Floor: " +floor);
        // // System.out.println("Ceil: " +ceil);

        // int floorDiff = Math.abs(k - floor);
        // int ceilDiff = Math.abs(k - ceil);

        // if (floorDiff < ceilDiff)
        //     System.out.println(floor);
        // else
        //     System.out.println(ceil);

        // ---------------NORMAL BINARY SEARCH APPROACH-----------------

        boolean flag = false;
        while (start <= end) {
            mid = end - (end - start) / 2;

            if (arr[mid] == k) {
                flag = true;
                break;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (flag) {
            System.out.println(arr[mid]);
        } else {
            int startDiff = Math.abs(k - arr[start]);
            int endDiff = Math.abs(k - arr[end]);

            if (startDiff < endDiff)
                System.out.println(arr[start]);
            else
                System.out.println(arr[end]);

        }

    }
}
