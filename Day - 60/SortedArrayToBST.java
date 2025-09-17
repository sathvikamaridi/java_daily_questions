public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return null; // placeholder
    }

    public static void main(String[] args) {
        SortedArrayToBST obj = new SortedArrayToBST();

        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = obj.sortedArrayToBST(nums1);
        obj.printTree(root1);

        int[] nums2 = {1, 2, 3};
        TreeNode root2 = obj.sortedArrayToBST(nums2);
        obj.printTree(root2);
    }

    // temporary print function
    public void printTree(TreeNode root) {
        preorder(root);
        System.out.println();
    }

    private void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }
}
