class Node {
    int data;
    Node prev, next;
    
    Node(int data) {
        this.data = data;
    }
}

public class DLLPairSum {

    public static void findPairsWithSum(Node head, int target) {
        Node start = head;
        Node end = head;

        // Move end to the tail node
        while (end.next != null) {
            end = end.next;
        }

        System.out.println("Pairs with sum " + target + ":");
        boolean found = false;

        // Use two-pointer approach
        while (start != null && end != null && start != end && end.next != start) {
            int sum = start.data + end.data;

            if (sum == target) {
                System.out.println("(" + start.data + ", " + end.data + ")");
                found = true;
                start = start.next;
                end = end.prev;
            } else if (sum < target) {
                start = start.next;
            } else {
                end = end.prev;
            }
        }

        if (!found) {
            System.out.println("No pairs found.");
        }
    }

    public static void main(String[] args) {
        // Build the linked list: 1 <-> 3 <-> 4 <-> 6 <-> 8 <-> 10
        Node head = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(4);
        Node n3 = new Node(6);
        Node n4 = new Node(8);
        Node n5 = new Node(10);

        // Linking nodes
        head.next = n1;
        n1.prev = head;
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;

        int target = 11;
        findPairsWithSum(head, target);
    }
}
