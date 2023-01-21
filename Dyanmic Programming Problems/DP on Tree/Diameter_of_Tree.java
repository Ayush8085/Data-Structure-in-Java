public class Diameter_of_Tree {

    // Return the longest possible path from leaf node to leaf node

    // --------------------------TREE---------------------
    
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static TreeNode root;

    public static void createBinaryTree() {
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(14);
        TreeNode forth = new TreeNode(4);
        TreeNode fifth = new TreeNode(11);

        root = first;
        first.left = second;
        first.right = third; // second <--- first ---> third

        second.left = forth;
        second.right = fifth; // forth <--- second ---> fifth
    }
    
    // --------------------------TREE---------------------
    
    public static void main(String[] args) {

        createBinaryTree();

        int ans = Integer.MIN_VALUE;

        System.out.println(diameterOfTree(root, ans));

    }

    private static int diameterOfTree(TreeNode node, int ans) {

        if (node == null) {
            return 0;
        }

        int left = diameterOfTree(node.left, ans);
        int right = diameterOfTree(node.right, ans);

        int temp = 1 + Math.max(left, right);
        int temp1 = Math.max((left + right + 1), temp);

        ans = Math.max(ans, temp1);

        return ans;
    }
}