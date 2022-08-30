import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        
        List<Integer> L = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements in list: ");
        int N = sc.nextInt();

        for(int i=0; i<N; i++) {
            L.add(sc.nextInt());
        }
        // for(int i=0; i<L.size(); i++) {

        //     System.out.print(L.get(i)+ " ");
        // }
        System.out.print("Number of queries: ");
        int Q = sc.nextInt();

        for(int i=0; i<Q; i++) {
            System.out.println("Operation: ");
            String operation = sc.next();

            if(operation.equals("Insert")) {
                System.out.print("At which index you want to insert: ");
                int atIndex = sc.nextInt();
                System.out.print("And what element you want to insert: ");
                int addElement = sc.nextInt();

                L.add(atIndex, addElement);
            }
            else {
                System.out.print("At what index you want to delete: ");
                int deleteAt = sc.nextInt();
                L.remove(deleteAt);
            }
        }
        System.out.println("After all the operations: ");
        for(int i=0; i<L.size(); i++) {
            System.out.print(L.get(i)+ " ");
        }
    }
}
