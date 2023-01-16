import java.util.Scanner;

class implementation {

    private static Node head;

    public static void main(String[] args) {

        head = null;

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
    
            switch (choice) {
                case 1:
                    printList();
                    break;
    
                case 2:
                    insertAtBeg();
                    break;
    
                // case 3:
                //     System.exit(0);
                //     break;
    
                default:
                    System.out.print("\nInvalid choice!!");
                    break;
            }
        }


    }

    private static void printList() {
        Node temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " --> ");

            temp = temp.next;
        }
        System.out.println("null");

    }

    private static void insertAtBeg() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the data you want to insert at the beginning: ");
        int data = sc.nextInt();

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        System.out.println("Node inserted successfully at the beginning");

        sc.close();
    }

    private static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}