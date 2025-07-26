class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListLoopRemoval {
    
    // Function to detect and remove loop
    public static void detectAndRemoveLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop using Floyd’s cycle detection
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected
            if (slow == fast) {
                System.out.println("Loop detected.");
                removeLoop(head, slow);
                return;
            }
        }
        System.out.println("No loop found.");
    }

    // Step 2: Remove loop
    private static void removeLoop(Node head, Node loopNode) {
        Node ptr1 = head;
        Node ptr2;

        // Find the start of the loop
        while (true) {
            ptr2 = loopNode;
            while (ptr2.next != loopNode && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }

            // If ptr2.next is ptr1, then ptr1 is at the loop starting point
            if (ptr2.next == ptr1) {
                break;
            }
            ptr1 = ptr1.next;
        }

        // Remove loop
        ptr2.next = null;
        System.out.println("Loop removed.");
    }

    // Utility to print the list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Driver Code
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a loop: 5 → 3
        head.next.next.next.next.next = head.next.next;

        detectAndRemoveLoop(head);

        System.out.println("Final Linked List:");
        printList(head);
    }
}
