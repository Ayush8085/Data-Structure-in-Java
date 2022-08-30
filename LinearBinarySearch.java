import java.util.Scanner;

public class LinearBinarySearch{

    //binary search algorithm
    public static int BinarySearch(int[] arr, int num)
    {
        int low = 0;
        int high = arr.length-1;
        int mid;

        while(low <= high)
        {
            mid = (low + high)/2;
    
            if(arr[mid] == num)
            {
                return mid;
            }
            if(arr[mid] < num)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;

    }

    //linear search algorithm
    public static int LinearSearch(int [] arr1, int num)
    {
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i] == num)
            {
                return i;
            }
        }
        return -1;
    } 
    public static void main(String[] args) {

        //array for binary search
        int [] arr = {1,3,5,7,9,10,14,19};

        //array for linear search
        int [] arr1 = {12,45,1,3,89,78,666};

        //taking input from the user 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to search : ");
        int num = sc.nextInt();

        //result of linear search
        if(LinearSearch(arr1, num) == -1)
        {
            System.out.println("Invalid Input!!");
        }
        else
        {
            System.out.println("Searched number " +num+ "is at index :" +LinearSearch(arr1, num));
        }

        //result of binary search
        if(BinarySearch(arr, num) == -1)
        {
            System.out.println("Invalid Input!!");
        }
        else
        {
            System.out.println("Searched number " +num+ "is at index :" +BinarySearch(arr, num));
        }

        sc.close();
    }
}