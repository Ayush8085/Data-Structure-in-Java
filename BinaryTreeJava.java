import java.util.Stack;

public class BinaryTreeJava {

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }
    TreeNode root;

    public void createBinaryTree() {
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(14);
        TreeNode forth = new TreeNode(4);
        TreeNode fifth = new TreeNode(11);

        root = first;
        first.left = second;
        first.right = third;    // second <--- first ---> third

        second.left = forth;
        second.right = fifth;   // forth <--- second ---> fifth
    }

    public void preOrederRecursive(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+ " ");
        preOrederRecursive(root.left);
        preOrederRecursive(root.right);
    }

    public void preOrederIterative(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data+ " ");
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public int findMax(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int rigth = findMax(root.right);

        if(left > result) {
            result = left;
        }
        if(rigth > result) {
            result = rigth;
        }

        return result;
    }

    public static void main(String[] args) {
        
        BinaryTreeJava bt = new BinaryTreeJava();
        bt.createBinaryTree();
        System.out.println("Binary tree created!!");

        bt.preOrederRecursive(bt.root);
        System.out.println();
        bt.preOrederIterative(bt.root);
        System.out.println("\nMaximum value in the tree: " +bt.findMax(bt.root));
    }
}
