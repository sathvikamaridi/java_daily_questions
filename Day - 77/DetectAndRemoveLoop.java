class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DetectAndRemoveLoop {
    Node head;


    public void detectAndRemoveLoop() {
        if (head == null || head.next == null) return;

        Node slow = head, fast = head;

        // Step 1: Detect Loop using Floyd's Cycle Detection
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Loop detected
                removeLoop(slow);
                return;
            }
        }
    }

    // Step 2: Remove loop
    private void removeLoop(Node loopNode) {
        Node ptr1 = head;
        Node ptr2 = loopNode;

        // Find the starting node of loop
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // ptr1 is now at the starting node of the loop
        // Traverse loop to find last node of loop
        Node temp = ptr1;
        while (temp.next != ptr1) {
            temp = temp.next;
        }
        temp.next = null; // Break the loop
    }

    // Utility function to print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DetectAndRemoveLoop list = new DetectAndRemoveLoop();

        // Test Case 1
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        // Creating loop: last node points to node 3
        list.head.next.next.next.next.next = list.head.next.next;

        list.detectAndRemoveLoop();
        System.out.print("Output (Test Case 1): ");
        list.printList();

        // Test Case 2
        DetectAndRemoveLoop list2 = new DetectAndRemoveLoop();
        list2.head = new Node(10);
        list2.head.next = new Node(20);
        list2.head.next.next = new Node(30);
        list2.head.next.next.next = new Node(40);

        list2.detectAndRemoveLoop();
        System.out.print("Output (Test Case 2): ");
        list2.printList();

        // Test Case 3
        DetectAndRemoveLoop list3 = new DetectAndRemoveLoop();
        list3.head = new Node(7);
        list3.head.next = new Node(14);
        list3.head.next.next = new Node(21);

        // Creating loop: last node points to head
        list3.head.next.next.next = list3.head;

        list3.detectAndRemoveLoop();
        System.out.print("Output (Test Case 3): ");
        list3.printList();
    }
}
