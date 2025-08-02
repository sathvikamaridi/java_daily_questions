class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class BinaryTreeToDLL {
    static TreeNode head = null;  // Head of DLL
    static TreeNode prev = null;  // Tracks previous node

    public static void convertToDLL(TreeNode root) {
        if (root == null) return;

        // Recurse on left subtree
        convertToDLL(root.left);

        // Process current node
        if (prev == null) {
            head = root;  // First node becomes head of DLL
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;  // Update previous node

        // Recurse on right subtree
        convertToDLL(root.right);
    }

    public static void printDLL(TreeNode node) {
        System.out.println("Doubly Linked List:");
        while (node != null) {
            System.out.print(node.data);
            if (node.right != null) System.out.print(" ⇄ ");
            node = node.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Construct Binary Tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        // Convert to DLL
        convertToDLL(root);

        // Print DLL
        printDLL(head);
    }
}
