import java.util.LinkedList;
import java.util.Queue;

public class Max_of_subarrays {

    public static void main(String[] args) {

        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        Queue<Integer> que = new LinkedList<>();
        que.add(arr[0]);
        int start = 0;
        int end = 0;
        int max = arr[0];

        while(end < arr.length) {

            if(max < arr[end]) {
                que.remove();
                max = arr[end];
            }

            if((end-start+1) < k) {
                end++;
            }
            else if((end-start+1) == k) {
                if(max < arr[end]) {
                    max = arr[end];
                }
                System.out.print(max+ " ");
                if(max == arr[start]) {

                }

                start++;
                end++;
            }
        }
    }
}
