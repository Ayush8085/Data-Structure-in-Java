import java.util.HashMap;
import java.util.Map;

// Give a boolean answer if targetSum can me made from adding the elements of the given array.

// Time complexity is O(targetSum * array.length)
// Space complexity is O(array.length)

public class can_sum {
    public static void main(String[] args) {

        
        Map<Integer, Boolean> map = new HashMap<>();
        int[] arr = {2,3};
        System.out.println(canSum(7, arr, map));
        
        Map<Integer, Boolean> map1 = new HashMap<>();
        int[] arr1 = {5,3,4,7};
        System.out.println(canSum(7, arr1, map1));
        
        Map<Integer, Boolean> map2 = new HashMap<>();
        int[] arr2 = {2,4};
        System.out.println(canSum(7, arr2, map2));
        
        Map<Integer, Boolean> map3 = new HashMap<>();
        int[] arr3 = {2,5,3};
        System.out.println(canSum(8, arr3, map3));
        
        Map<Integer, Boolean> map4 = new HashMap<>();
        int[] arr4 = {7,14};
        System.out.println(canSum(300, arr4, map4));

    }

    private static boolean canSum(int targetSum, int[] arr, Map<Integer, Boolean> map) {
        if(map.containsKey(targetSum)) {
            return map.get(targetSum);
        }
        if(targetSum == 0) {
            return true;
        }
        if(targetSum < 0) {
            return false;
        }

        for (int element : arr) {
            int rem = targetSum - element;
            if(canSum(rem, arr, map)==true) {
                map.put(targetSum, true);
                return true;
            }
        }

        map.put(targetSum, false);
        return false;
    }
}
