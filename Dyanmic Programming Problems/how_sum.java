import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Given a targetsum and an array, return a list of elements which add up to the targetsum. If not possible return null.

// Targetsum --> m
// arr.lenght --> n
// Time complexity is O(n*m^2)
// Space complexity is O(n^2)

public class how_sum {
    public static void main(String[] args) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] arr = { 2, 3 };
        System.out.println(howSum(7, arr, map));

        Map<Integer, ArrayList<Integer>> map1 = new HashMap<>();
        int[] arr1 = { 5, 3, 4, 7 };
        System.out.println(howSum(7, arr1, map1));

        Map<Integer, ArrayList<Integer>> map2 = new HashMap<>();
        int[] arr2 = { 2, 4 };
        System.out.println(howSum(7, arr2, map2));

        Map<Integer, ArrayList<Integer>> map3 = new HashMap<>();
        int[] arr3 = { 2, 3, 5 };
        System.out.println(howSum(8, arr3, map3));

        Map<Integer, ArrayList<Integer>> map4 = new HashMap<>();
        int[] arr4 = { 7, 14 };
        System.out.println(howSum(300, arr4, map4));
    }

    private static ArrayList<Integer> howSum(int targetSum, int[] arr, Map<Integer, ArrayList<Integer>> map) {

        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        if (map.containsKey(targetSum))
            return map.get(targetSum);

        for (int element : arr) {
            int rem = targetSum - element;
            ArrayList<Integer> remResult = howSum(rem, arr, map);
            if (remResult != null) {
                remResult.add(element);
                map.put(targetSum, remResult);
                return remResult;
            }
        }

        map.put(targetSum, null);
        return null;
    }
}
