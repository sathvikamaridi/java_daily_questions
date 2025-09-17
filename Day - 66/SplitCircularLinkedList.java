class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SplitCircularLinkedList {
    Node head;

    // Function to insert at end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // circular
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    // Print circular list
    public void printList(Node head) {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Split circular linked list into two halves
    public void splitList() {
        if (head == null || head.next == head) return;

        Node slow = head, fast = head;

        // Use slow/fast to reach middle
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // For even number of nodes, move fast one step further
        if (fast.next.next == head) {
            fast = fast.next;
        }

        // First half head
        Node head1 = head;

        // Second half head
        Node head2 = slow.next;

        // Make two halves circular
        fast.next = head2;
        slow.next = head1;

        System.out.print("First Half: ");
        printList(head1);

        System.out.print("Second Half: ");
        printList(head2);
    }

    public static void main(String[] args) {
        // Test Case 01
        SplitCircularLinkedList cll1 = new SplitCircularLinkedList();
        cll1.insert(10);
        cll1.insert(20);
        cll1.insert(30);
        cll1.insert(40);
        cll1.insert(50);
        cll1.insert(60);

        System.out.println("Test Case 01:");
        cll1.splitList();

        // Test Case 02
        SplitCircularLinkedList cll2 = new SplitCircularLinkedList();
        cll2.insert(1);
        cll2.insert(2);
        cll2.insert(3);
        cll2.insert(4);
        cll2.insert(5);

        System.out.println("\nTest Case 02:");
        cll2.splitList();
    }
}
