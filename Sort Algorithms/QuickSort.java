public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {3, 5, 2, 13, 12, 3, 10, 56, 5, 8};
        int len = arr.length;

        System.out.print("Before Sorting: ");
        printArray(arr, len);

        quickSort(arr, 0, len-1);

        System.out.print("After Sorting: ");
        printArray(arr, len);

    }

    public static void printArray(int[] arr, int len) {                 // Method for printing the array
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int low, int high) {         // Method for quick Sorting the array

        int partitionIndex;

        if(low < high) {
            partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex-1);
            quickSort(arr, partitionIndex+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {         // Method for identifing the partition index of the array
        int pivot = arr[low];                                           // or the sub-array
        int i = low + 1;
        int j = high;
        int temp;

        do {
            while (arr[i] <= pivot) i++;

            while (arr[j] > pivot) j--;

            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } while (i < j);

        temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;

    }
}
