import java.util.*;
// import java.lang.*;
// import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
        System.out.println("Test cases: ");
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
            System.out.println("Size of array: ");
		    int N = sc.nextInt();
		    int[] A = new int[N];
		    
		    for(int j=0; j<N; j++) {
                System.out.println("Put element at index " +j+ ": ");
		        A[j] = sc.nextInt();
		    }
		    
		    if(A.length == 2) {
		        System.out.println(A[0] + A[1]);
		    }
		    else {
		        int greatestSum = 0;
		        for(int j=1; j<N; j++) {
		            int currentSum;
		            currentSum = A[j] + A[j-1];
		            if(currentSum > greatestSum) {
		                greatestSum = currentSum;
		            }
		        }
		        System.out.println(greatestSum);
		    }
		}
	}
}
