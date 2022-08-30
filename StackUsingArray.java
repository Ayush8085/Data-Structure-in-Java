import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class StackUsingArray {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();

        operationOnStack(stk, sc);

    }

    //Operating on the stack
    public static void operationOnStack(Stack<Integer> stk, Scanner sc){
        while(true){
            System.out.print("Press 1 for PUSH, 2 for POP, 3 for PEEK, 4 for SEARCH, 5 for SIZE and 6 to exit: ");
            int userInput = sc.nextInt();
            if(userInput == 1){
                System.out.flush();
                stk.push(elementToPush(sc));
                System.out.println(stk);
            }
            else if(userInput == 2){
                try{
                    stk.pop();
                    System.out.println(stk);
                }
                catch (EmptyStackException e){
                    System.out.println("The stack is empty!!");
                }
            }
            else if(userInput == 3){
                System.out.println("Element at the top of the stack: " +stk.peek());
            }
            else if(userInput == 4){
                System.out.println( stk.search(elementToSearch(sc)));
            }
            else if(userInput == 5){
                System.out.println("Size of the stack is: " +stk.size());
            }
            else if(userInput == 6){
                System.exit(2);
            }
            else{
                System.out.println("Invalid input!!");
                System.out.println(stk);
            }
        }
    }

    //Taking the element from the user to PUSH
    public static int elementToPush(Scanner sc){
        System.out.println("Which element you want to PUSH into the stack: ");
        int ele = sc.nextInt();
        return ele;
    }

    //Taking the element from the user to SEARCH
    public static int elementToSearch(Scanner sc){
        System.out.println("Which element you want to SEARCH for into the stack: ");
        int searchElement = sc.nextInt();
        return searchElement;
    }
}
