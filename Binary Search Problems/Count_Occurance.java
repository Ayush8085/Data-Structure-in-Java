public class Count_Occurance {

    // Return how many times 'k' has occured in the given sorted array.

    public static void main(String[] args) {

        int[] arr = { 2, 4, 10, 10, 10, 18, 20 };
        int k = 10;

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        int count = 0;
        int firstOccurance = -1;
        while (start <= end) {
            mid = end - (end - start) / 2;

            if (arr[mid] < k) {
                start = mid + 1;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                firstOccurance = mid;
                end = mid - 1;
            }
        }

        if (firstOccurance != -1) {
            int i = firstOccurance;
            while (true) {
                if (arr[i] == k)
                    count++;
                else
                    break;
                i++;
            }
        }

        System.out.println(count);
    }
}
