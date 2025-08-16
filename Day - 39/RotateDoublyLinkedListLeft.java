class DoublyListNode {
    String data;
    DoublyListNode prev, next;

    DoublyListNode(String data) {
        this.data = data;
    }
}

public class RotateDoublyLinkedListLeft {
    public static DoublyListNode rotateLeft(DoublyListNode head, int k) {
        if (head == null || k == 0) return head;

        // Step 1: Find length and last node
        DoublyListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Adjust k if > length
        k = k % length;
        if (k == 0) return head;

        // Step 3: Traverse to kth node
        DoublyListNode newHead = head;
        for (int i = 0; i < k; i++) {
            newHead = newHead.next;
        }

        // Step 4: Break the list into two parts
        DoublyListNode newTail = newHead.prev;
        newTail.next = null;
        newHead.prev = null;

        // Step 5: Attach old head at the end
        tail.next = head;
        head.prev = tail;

        return newHead;
    }

    // Utility to print doubly linked list
    public static void printList(DoublyListNode head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" ⇄ ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: A ⇄ B ⇄ C ⇄ D ⇄ E ⇄ F, k=2
        DoublyListNode head1 = new DoublyListNode("A");
        head1.next = new DoublyListNode("B"); head1.next.prev = head1;
        head1.next.next = new DoublyListNode("C"); head1.next.next.prev = head1.next;
        head1.next.next.next = new DoublyListNode("D"); head1.next.next.next.prev = head1.next.next;
        head1.next.next.next.next = new DoublyListNode("E"); head1.next.next.next.next.prev = head1.next.next.next;
        head1.next.next.next.next.next = new DoublyListNode("F"); head1.next.next.next.next.next.prev = head1.next.next.next.next;

        System.out.print("Output: ");
        printList(rotateLeft(head1, 2));  // C ⇄ D ⇄ E ⇄ F ⇄ A ⇄ B

        // Test Case 2: 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5, k=4
        DoublyListNode head2 = new DoublyListNode("1");
        head2.next = new DoublyListNode("2"); head2.next.prev = head2;
        head2.next.next = new DoublyListNode("3"); head2.next.next.prev = head2.next;
        head2.next.next.next = new DoublyListNode("4"); head2.next.next.next.prev = head2.next.next;
        head2.next.next.next.next = new DoublyListNode("5"); head2.next.next.next.next.prev = head2.next.next.next;

        System.out.print("Output: ");
        printList(rotateLeft(head2, 4));  // 5 ⇄ 1 ⇄ 2 ⇄ 3 ⇄ 4
    }
}
