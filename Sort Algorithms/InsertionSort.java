public class InsertionSort {
    public static void main(String[] args) {
        
        int[] arr = {34, 23, 56, 67, 2, 1};
        int len = arr.length;

        System.out.print("Before sorting: ");
        printArray(arr, len);                               // Method for printing the given array

        insertionSort(arr, len);                            // Method for insertion sorting the array

        System.out.print("After sorting: ");
        printArray(arr, len);
    }

    public static void printArray(int[] arr, int len)       // Method for printing the given array
    {
        for(int i=0; i < len; i++)
        {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void insertionSort(int[] arr, int len)    // Method for insertion sorting the array
    {
        int key, j;

        for(int i=1; i < len; i++) // loop for passes
        {
            System.out.println("Number of passes made: " +i);
            key = arr[i];
            j = i-1;

            while( j >= 0 && arr[j] > key) 
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
