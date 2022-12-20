public class fibonacci_tab {
    
    public static void main(String[] args) {
        
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(50));
        System.out.println(fib(70));
    }

    private static long fib(int target) {

        long[] table = new long[target+1];

        for(int i=0; i<=target; i++) {
            table[i] = 0;
        }
        table[1] = 1;

        for(int i=0; i<target; i++) {
            if(i+1 == target) {
                table[i+1] += table[i];
            }
            else {
                table[i+1] += table[i];
                table[i+2] += table[i];
            }
        }

        return table[target];
    }
}
