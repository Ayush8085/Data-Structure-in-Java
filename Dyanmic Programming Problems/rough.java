import java.util.ArrayList;

public class rough {

    public static void main(String[] args) {

        // ArrayList<ArrayList<Integer>> table = new ArrayList<>(7);

        // // for (ArrayList<Integer> row : table) {
        // // row = null;
        // // }
        // for(int row=1; row<table.size(); row++) {
        // table.set(row, null);
        // }

        // // table.set(0, new ArrayList<>());

        // // for (int row = 0; row < table.size(); row++) {
        // // System.out.println();
        // // for (int col = 0; col < table.get(row).size(); col++) {
        // // System.out.print(table.get(row).get(col));
        // // }
        // // }

        // System.out.println(table);

        int[][] table = new int[8][4];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = -1;
            }
        }

        for (int i = 0; i < table.length; i++) {
            System.out.println();
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j] + " ");
            }
        }
        table[0][0] = 0;
        System.out.println();

        for (int i = 0; i < table.length; i++) {
            System.out.println();
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j] + " ");
            }
        }
    }
}
