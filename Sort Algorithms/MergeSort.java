public class MergeSort {
    public static void main(String[] args) {
        
        int[] arr1 = {2, 8, 14, 15, 29, 90};                            // First sorted array
        int len1 = arr1.length;

        int[] arr2 = {3, 7, 9, 12, 18, 29, 89, 104};                    // Second sorted array
        int len2 = arr2.length;

        int[] arr3 = new int[(len1+len2)];                              // Allocating space for merge sort array
        int len3 = arr3.length;

        System.out.println("Before Sorting: ");
        printArrays(arr1, arr2, len1, len2);                            // Method for printing the two sorted arrays

        mergeSort(arr1, arr2, arr3, len1, len2);                        // Method for Merge sorting the given two arrays

        System.out.print("After Sorting: ");
        printSortedArray(arr3, len3);                                   // Method for printing the sorted array
    }

    public static void printArrays(int[] arr1, int[] arr2, int len1, int len2)  // Method for printing the two sorted arrays
    {
        System.out.print("First sorted array: ");
        for(int i=0; i<len1; i++) {
            System.out.print(arr1[i]+ " ");
        }
        System.out.println();

        System.out.print("Second sorted array: ");
        for(int i=0; i<len2; i++) {
            System.out.print(arr2[i]+ " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr1, int[] arr2, int[] arr3, int len1, int len2)   // Method for Merge sorting the given two arrays
    {
        int i, j, k;
        i = j = k = 0;

        while(i < len1 && j < len2) {

            if(arr1[i] <= arr2[j]) {        
                arr3[k] = arr1[i];
                i++;
                k++;
            }
            else {
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }

        while(i < len1) {
            arr3[k] = arr1[i];
            i++;
            k++;
        }

        while(j < len2) {
            arr3[k] = arr2[j];
            j++;
            k++;
        }
    }

    public static void printSortedArray(int[] arr3, int len3)           // Method for printing the sorted array
    {
        for(int i=0; i<len3; i++) {
            System.out.print(arr3[i]+ " ");
        }
        System.out.println();
    }
}
