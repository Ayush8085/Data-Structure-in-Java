import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SlidingWindow_Problem {

    public static int[] nextGreatestValue(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            if(!stack.isEmpty()) {
                while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                    stack.pop();
                }
            }

            if(stack.isEmpty()) {
                result[i] = arr.length;
            }
            else {
                result[i] = stack.peek();
            }

            stack.push(i);
        }

        return result;
    }

    public static List<Integer> slidingWindow(int[] arr, int[] ngeArr, int k) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<=arr.length-k; i++) {
            int j=i;

            while(ngeArr[j] < i+k) {
                j = ngeArr[j];
            }

            list.add(arr[j]);
        }
        return list;
    }

    public static void main(String[] args) {

        int[] widths = { 44, 77, 33, 44, 88, 11 };
        int k = 3;

        int[] ans = nextGreatestValue(widths);

        List<Integer> list = slidingWindow(widths, ans, k);

        for(int i: list) {
            System.out.println(i);
        }
        
    }
}
