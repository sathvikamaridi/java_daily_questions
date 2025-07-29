class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class InorderSuccessorBST {

    static Node root;

    // Function to find the inorder successor
    public static Node inorderSuccessor(Node root, Node target) {
        Node successor = null;

        while (root != null) {
            if (target.data < root.data) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    public static Node search(Node root, int key) {
        if (root == null || root.data == key)
            return root;
        if (key < root.data)
            return search(root.left, key);
        return search(root.right, key);
    }

    public static void main(String[] args) {
        root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right.right = new Node(40);

        int targetValue = 15;
        Node target = search(root, targetValue);
        Node successor = inorderSuccessor(root, target);

        if (successor != null)
            System.out.println("Inorder Successor of " + targetValue + " is: " + successor.data);
        else
            System.out.println("Inorder Successor of " + targetValue + " does not exist.");
    }
}
