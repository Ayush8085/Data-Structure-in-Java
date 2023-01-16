import java.util.LinkedList;
import java.util.Queue;

public class First_negative {
    public static void main(String[] args) {

        int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28, -9 };
        int k = 3;

        Queue<Integer> que = new LinkedList<>();
        int start = 0;
        int end = 0;

        while(end < arr.length) {

            if(arr[end] < 0) {
                que.add(arr[end]);
            }

            if((end-start+1) < k) {
                end++;
            }
            else if((end-start+1) == k) {
                if(que.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(que.peek());
                }
                if((que.peek()!=null) && (que.peek()==arr[start])) {
                    que.remove();
                }

                start++;
                end++;
            }
        }
    }
}
