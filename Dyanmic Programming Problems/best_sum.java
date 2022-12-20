import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// I WAS ENABLE TO SOLVE THIS PROBLEM

public class best_sum {
    public static void main(String[] args) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] arr = { 5, 3, 4, 7 };
        System.out.println(bestSum(7, arr, map));

        Map<Integer, ArrayList<Integer>> map1 = new HashMap<>();
        int[] arr1 = { 5, 3, 2 };
        System.out.println(bestSum(8, arr1, map1));

        Map<Integer, ArrayList<Integer>> map2 = new HashMap<>();
        int[] arr2 = { 1, 5, 4 };
        System.out.println(bestSum(8, arr2, map2));

        Map<Integer, ArrayList<Integer>> map3 = new HashMap<>();
        int[] arr3 = { 1, 5, 2, 25 };
        System.out.println(bestSum(100, arr3, map3));
    }

    private static ArrayList<Integer> bestSum(int targetSum, int[] arr, Map<Integer, ArrayList<Integer>> map) {

        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        if (map.containsKey(targetSum))
            return map.get(targetSum);

        ArrayList<Integer> shortestCombination = null;

        for (int element : arr) {
            int rem = targetSum - element;
            ArrayList<Integer> remCombination = bestSum(rem, arr, map);
            if (remCombination != null) {
                remCombination.add(element);
                if (shortestCombination == null || remCombination.size() < shortestCombination.size()) {
                    shortestCombination = remCombination;
                }
            }
        }

        map.put(targetSum, shortestCombination);
        return shortestCombination;
    }
}
