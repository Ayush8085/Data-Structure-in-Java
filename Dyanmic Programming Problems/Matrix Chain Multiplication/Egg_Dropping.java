public class Egg_Dropping {

    // Find the minimum no. of attempts to get teh maximum height at which the egg
    // will not break.

    public static void main(String[] args) {

        // int e = 3;
        // int f = 8;

        int e = 2;
        int f = 10;

        int ans = eggDropping(e, f);

        System.out.println(ans);

    }

    private static int eggDropping(int e, int f) {

        if (f == 0 || f == 1 || e == 1) {
            return f;
        }

        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int tempAns = 1 + Math.max(eggDropping(e - 1, k - 1), eggDropping(e, f - k));
            min = Math.min(tempAns, min);
        }

        return min;

    }
}
