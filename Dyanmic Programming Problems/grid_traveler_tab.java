public class grid_traveler_tab {

    public static void main(String[] args) {

        System.out.println(gridTraveler(1, 1));
        System.out.println(gridTraveler(2, 3));
        System.out.println(gridTraveler(3, 2));
        System.out.println(gridTraveler(3, 3));
        System.out.println(gridTraveler(18, 18));
    }

    private static long gridTraveler(int row, int col) {

        long[][] table = new long[row + 1][col + 1];

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                table[row][col] = 0;
            }
        }
        table[1][1] = 1;

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (i + 1 <= row)
                    table[i + 1][j] += table[i][j];
                if (j + 1 <= col)
                    table[i][j + 1] += table[i][j];
            }
        }

        return table[row][col];
    }
}
