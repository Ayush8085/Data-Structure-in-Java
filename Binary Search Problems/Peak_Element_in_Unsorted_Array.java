public class Peak_Element_in_Unsorted_Array {

    // Return any one peak element from the given unsorted array.

    // Peak element --> (i-1)th < ith > (i+1)th
    // if i=0 than { ith > (i+1)th }
    // if i=arr.len than { ith > (arr.len-1)th }

    public static void main(String[] args) {

        int[] arr = { 5, 10, 20, 15 };

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