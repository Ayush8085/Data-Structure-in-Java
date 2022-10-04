public class HeapSort {

    // Method for sorting the heap
    private static void heapSort(int[] arr, int N) {

        for(int i=N-1; i>0; i--) {
            swap(arr, i, 0);

            heapify(arr, i, 0);
        }
    }

    // Method for building the heap
    private static void buildHeap(int[] arr) {

        int N = arr.length;

        for(int i=N/2-1; i>=0; i--) {
            heapify(arr, N, i);
        }

        heapSort(arr, N);
    }

    private static void heapify(int[] arr, int N, int i) {

        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<N && arr[l] > arr[largest]) {
            largest = l;
        }
        if(r<N && arr[r] > arr[largest]) {
            largest = r;
        }

        if(largest != i) {
            swap(arr, i, largest);

            heapify(arr, N, largest);
        }
    }

    // Method to swap two elements in an array
    private static void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }

    // Method for printing the array
    private static void printArray(int[] arr) {

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.print("\nBefore sorting: ");
        printArray(arr);
        System.out.println();
        buildHeap(arr);
        System.out.print("After sorting: ");
        printArray(arr);

    }
}
