class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class SplitCircularLinkedList {
    public static void splitList(Node head) {
        if (head == null || head.next == head) {
            System.out.println("Cannot split, insufficient nodes.");
            return;
        }

        Node slow = head, fast = head;

        // Step 1: Find middle using slow & fast pointers
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: If even nodes, move fast to the last node
        if (fast.next.next == head) {
            fast = fast.next;
        }

        // Step 3: Set head pointers for both lists
        Node head1 = head;
        Node head2 = slow.next;

        // Step 4: Make the two halves circular
        fast.next = head2;
        slow.next = head1;

        // Print both lists
        System.out.print("List 1: ");
        printCircularList(head1);
        System.out.print("List 2: ");
        printCircularList(head2);
    }

    // Utility function to print a circular list
    public static void printCircularList(Node head) {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != head) System.out.print(" ⇄ ");
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1
        Node head1 = new Node("10");
        head1.next = new Node("20");
        head1.next.next = new Node("30");
        head1.next.next.next = new Node("40");
        head1.next.next.next.next = new Node("50");
        head1.next.next.next.next.next = head1; // make circular

        System.out.println("Test Case 1:");
        splitList(head1);

        // Test Case 2
        Node head2 = new Node("A");
        head2.next = new Node("B");
        head2.next.next = new Node("C");
        head2.next.next.next = new Node("D");
        head2.next.next.next.next = new Node("E");
        head2.next.next.next.next.next = new Node("F");
        head2.next.next.next.next.next.next = head2; // make circular

        System.out.println("Test Case 2:");
        splitList(head2);
    }
}
