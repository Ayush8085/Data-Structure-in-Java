public class BubbleSort {
    public static void main(String[] args) {
        
        int []arr = {23, 1, 56, 34, 67, 78};
        int len = arr.length;

        System.out.print("Before Sorting: ");
        printArray(arr, len);                   // Method for printing the array

        System.out.println();

        bubbleSort(arr, len);                   // Method for bubble sorting the array

        System.out.print("After Sorting: ");
        printArray(arr, len);
    }

    public static void printArray(int []arr, int len)    // Method for printing the given array
    {
        for(int i=0; i<len; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    public static void bubbleSort(int []arr, int len)    // Method for bubble soring the given array
    {
        int temp;

        for(int i=0; i<len-1; i++)
        {
            System.out.println("Number of passes made: " +(i+1));
            for(int j=0; j<len-1-i; j++) {
                
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}