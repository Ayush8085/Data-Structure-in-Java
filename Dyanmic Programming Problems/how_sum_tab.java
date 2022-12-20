import java.util.ArrayList;

public class how_sum_tab {

    public static void main(String[] args) {

        int[] arr = { 2, 3 };
        // System.out.println(howSum(7, arr));
        howSum(7, arr);

        // int[] arr1 = { 5, 3, 4, 7 };
        // System.out.println(howSum(7, arr1));

        // int[] arr2 = { 2, 4 };
        // System.out.println(howSum(7, arr2));

        // int[] arr3 = { 2, 3, 5 };
        // System.out.println(howSum(8, arr3));

        // int[] arr4 = { 7, 14 };
        // System.out.println(howSum(300, arr4));
    }

    private static void howSum(int targetSum, int[] arr) {

        int[][] table = new int[targetSum + 1][arr.length + 1];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = -1;
            }
        }

        table[0][0] = 0;

        for (int row = 0; row <= targetSum; row++) {
            // for(int col=0; col<=arr.length; col++) {
            if (table[row][0] != -1) {

                for (int element : arr) {
                    for (int col = 0; col < table[0].length; col++) {
                        if ((row + element <= targetSum)
                                && (table[row + element][col] == -1 || table[row + element][col] == 0))

                            table[row + element][col] = table[row][col];
                    }

                }

            }
            // }
        }

        System.out.println();
        // for(int col=0; col<table[0].length; col++) {
        // System.out.print(table[targetSum][col]+ " ");
        // }

        for (int row = 0; row <= targetSum; row++) {
            System.out.println();
            for (int col = 0; col <= arr.length; col++) {
                System.out.print(table[row][col] + " ");
            }
        }

    }
}
