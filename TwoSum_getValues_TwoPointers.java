import java.util.Arrays;

// In this, we have to return the indices of two integers whose sum is equal to the target provided.

public class TwoSum_getValues_TwoPointers {
    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] arr = { 2, 11, 5, 10, 7, 8 };

        int[] result = sum.twoSum(arr, 9);
        System.out.println("The two values are: " + result[0] + " and " + result[1]);
    }
}

class TwoSum {

    public int[] twoSum(int[] arr, int target) {
        Arrays.sort(arr); // Sorting the array

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (target == arr[left] + arr[right]) {
                return new int[] { arr[left], arr[right] };
            } else if (target > arr[left] + arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        throw new IllegalArgumentException("Values not found!!");
    }
}