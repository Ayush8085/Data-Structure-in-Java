public class SelectionSort {
    public static void main(String[] args) {
        
        int[] arr = {23, 56, 1, 7, 0};
        int len = arr.length;

        System.out.print("Before Sorting: ");
        printArray(arr, len);

        selectionSort(arr, len);

        System.out.print("After Sorting: ");
        printArray(arr, len);
    }

    public static void printArray(int []arr, int len) {         // Method for printing the array
        for(int i=0; i<len; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr, int len) {      // Method for sorting the array

        int indexOfMin;

        for(int i=0; i < len-1; i++) {  // For passes

            // System.out.println("Number of passes: " +(i+1));

            indexOfMin = i;

            for(int j=i+1; j < len; j++) {
                if(arr[j] < arr[indexOfMin]) {
                    indexOfMin = j;
                }
            }

            swapNum(arr, indexOfMin, i);
        }
    }

    public static void swapNum(int[] arr, int indexOfMin, int i) {            // Method for swapping
        int temp;

        temp = arr[indexOfMin];
        arr[indexOfMin] = arr[i];
        arr[i] = temp;

    }
}
