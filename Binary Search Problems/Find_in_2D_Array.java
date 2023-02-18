public class Find_in_2D_Array {

    // Return index of 'k' in given sorted 2D array.

    public static void main(String[] args) {

        int[][] arr = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };
        int k = 34;

        int row = 0;
        int col = arr[0].length - 1;

        while ((row >= 0 && row < arr.length) && (col >= 0 && col < arr[0].length)) {

            if (arr[row][col] == k) {
                break;
            } else if (arr[row][col] > k) {
                col--;
            } else if (arr[row][col] < k) {
                row++;
            }
        }

        if (row < 0 || row >= arr.length - 1 || col < 0 || col >= arr[0].length - 1)
            System.out.println("Not Found");
        else
            System.out.println("Row: " + row + "\nColumn :" + col);
    }
}
