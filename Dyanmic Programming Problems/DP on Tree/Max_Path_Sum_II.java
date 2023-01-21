public class Max_Path_Sum_II {

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

    // --------------------------TREE---------------------

    public static void main(String[] args) {

        root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // root = new TreeNode(9);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(14);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(11);

        int ans = Integer.MIN_VALUE;

        System.out.println(maxPathSumLeafToLeaf(root, ans));

    }

    private static int maxPathSumLeafToLeaf(TreeNode node, int ans) {

        if(node == null) {
            return 0;
        }

        int left = maxPathSumLeafToLeaf(node.left, ans);
        int right = maxPathSumLeafToLeaf(node.right, ans);

        int temp = Math.max(left, right) + node.data;
        if(node.left==null && node.right==null) {
            temp = Math.max(temp, node.data);
        }
        int temp1 = Math.max(temp, (left+right+node.data));

        ans = Math.max(ans, temp1);

        return ans;
    }
}
