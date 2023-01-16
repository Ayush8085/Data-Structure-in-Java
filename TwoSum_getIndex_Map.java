import java.util.HashMap;

public class TwoSum_getIndex_Map {
    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] arr = {10, 2, 11, 6, 7, 0};

        int[] result = sum.twoSum(arr, 9);
        System.out.println("The two indices are: " +result[0]+ " and " +result[1]);
    }
}

class TwoSum {

    public int[] twoSum(int[] arr, int target) {

        // int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {

            if(!map.containsKey(target-arr[i])) {
                map.put(arr[i], i);
            }
            else {
                // result[0] = i;
                // result[1] = map.get(target-arr[i]);
                return new int[] {map.get(target-arr[i]), i};
            }
        }
        
        throw new IllegalArgumentException("Indices not found!!");
    }
}